/*
 * Decompiled with CFR 0_118.
 */
package com.keypoint;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

public class PngEncoder {
    public static final boolean ENCODE_ALPHA = true;
    public static final boolean NO_ALPHA = false;
    public static final int FILTER_NONE = 0;
    public static final int FILTER_SUB = 1;
    public static final int FILTER_UP = 2;
    public static final int FILTER_LAST = 2;
    protected static final byte[] IHDR = new byte[]{73, 72, 68, 82};
    protected static final byte[] IDAT = new byte[]{73, 68, 65, 84};
    protected static final byte[] IEND = new byte[]{73, 69, 78, 68};
    protected static final byte[] PHYS = new byte[]{112, 72, 89, 115};
    protected byte[] pngBytes;
    protected byte[] priorRow;
    protected byte[] leftBytes;
    protected Image image;
    protected int width;
    protected int height;
    protected int bytePos;
    protected int maxPos;
    protected CRC32 crc = new CRC32();
    protected long crcValue;
    protected boolean encodeAlpha;
    protected int filter;
    protected int bytesPerPixel;
    private int xDpi = 0;
    private int yDpi = 0;
    private static float INCH_IN_METER_UNIT = 0.0254f;
    protected int compressionLevel;

    public PngEncoder() {
        this(null, false, 0, 0);
    }

    public PngEncoder(Image image) {
        this(image, false, 0, 0);
    }

    public PngEncoder(Image image, boolean encodeAlpha) {
        this(image, encodeAlpha, 0, 0);
    }

    public PngEncoder(Image image, boolean encodeAlpha, int whichFilter) {
        this(image, encodeAlpha, whichFilter, 0);
    }

    public PngEncoder(Image image, boolean encodeAlpha, int whichFilter, int compLevel) {
        this.image = image;
        this.encodeAlpha = encodeAlpha;
        this.setFilter(whichFilter);
        if (compLevel >= 0 && compLevel <= 9) {
            this.compressionLevel = compLevel;
        }
    }

    public void setImage(Image image) {
        this.image = image;
        this.pngBytes = null;
    }

    public Image getImage() {
        return this.image;
    }

    public byte[] pngEncode(boolean encodeAlpha) {
        byte[] pngIdBytes = new byte[]{-119, 80, 78, 71, 13, 10, 26, 10};
        if (this.image == null) {
            return null;
        }
        this.width = this.image.getWidth(null);
        this.height = this.image.getHeight(null);
        this.pngBytes = new byte[(this.width + 1) * this.height * 3 + 200];
        this.maxPos = 0;
        this.bytePos = this.writeBytes(pngIdBytes, 0);
        this.writeHeader();
        this.writeResolution();
        if (this.writeImageData()) {
            this.writeEnd();
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.maxPos);
        } else {
            this.pngBytes = null;
        }
        return this.pngBytes;
    }

    public byte[] pngEncode() {
        return this.pngEncode(this.encodeAlpha);
    }

    public void setEncodeAlpha(boolean encodeAlpha) {
        this.encodeAlpha = encodeAlpha;
    }

    public boolean getEncodeAlpha() {
        return this.encodeAlpha;
    }

    public void setFilter(int whichFilter) {
        this.filter = 0;
        if (whichFilter <= 2) {
            this.filter = whichFilter;
        }
    }

    public int getFilter() {
        return this.filter;
    }

    public void setCompressionLevel(int level) {
        if (level >= 0 && level <= 9) {
            this.compressionLevel = level;
        }
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    protected byte[] resizeByteArray(byte[] array, int newLength) {
        byte[] newArray = new byte[newLength];
        int oldLength = array.length;
        System.arraycopy(array, 0, newArray, 0, Math.min(oldLength, newLength));
        return newArray;
    }

    protected int writeBytes(byte[] data, int offset) {
        this.maxPos = Math.max(this.maxPos, offset + data.length);
        if (data.length + offset > this.pngBytes.length) {
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, data.length));
        }
        System.arraycopy(data, 0, this.pngBytes, offset, data.length);
        return offset + data.length;
    }

    protected int writeBytes(byte[] data, int nBytes, int offset) {
        this.maxPos = Math.max(this.maxPos, offset + nBytes);
        if (nBytes + offset > this.pngBytes.length) {
            this.pngBytes = this.resizeByteArray(this.pngBytes, this.pngBytes.length + Math.max(1000, nBytes));
        }
        System.arraycopy(data, 0, this.pngBytes, offset, nBytes);
        return offset + nBytes;
    }

    protected int writeInt2(int n, int offset) {
        byte[] temp = new byte[]{(byte)(n >> 8 & 255), (byte)(n & 255)};
        return this.writeBytes(temp, offset);
    }

    protected int writeInt4(int n, int offset) {
        byte[] temp = new byte[]{(byte)(n >> 24 & 255), (byte)(n >> 16 & 255), (byte)(n >> 8 & 255), (byte)(n & 255)};
        return this.writeBytes(temp, offset);
    }

    protected int writeByte(int b, int offset) {
        byte[] temp = new byte[]{(byte)b};
        return this.writeBytes(temp, offset);
    }

    protected void writeHeader() {
        int startPos = this.bytePos = this.writeInt4(13, this.bytePos);
        this.bytePos = this.writeBytes(IHDR, this.bytePos);
        this.width = this.image.getWidth(null);
        this.height = this.image.getHeight(null);
        this.bytePos = this.writeInt4(this.width, this.bytePos);
        this.bytePos = this.writeInt4(this.height, this.bytePos);
        this.bytePos = this.writeByte(8, this.bytePos);
        this.bytePos = this.writeByte(this.encodeAlpha ? 6 : 2, this.bytePos);
        this.bytePos = this.writeByte(0, this.bytePos);
        this.bytePos = this.writeByte(0, this.bytePos);
        this.bytePos = this.writeByte(0, this.bytePos);
        this.crc.reset();
        this.crc.update(this.pngBytes, startPos, this.bytePos - startPos);
        this.crcValue = this.crc.getValue();
        this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
    }

    protected void filterSub(byte[] pixels, int startPos, int width) {
        int offset = this.bytesPerPixel;
        int actualStart = startPos + offset;
        int nBytes = width * this.bytesPerPixel;
        int leftInsert = offset;
        int leftExtract = 0;
        for (int i = actualStart; i < startPos + nBytes; ++i) {
            this.leftBytes[leftInsert] = pixels[i];
            pixels[i] = (byte)((pixels[i] - this.leftBytes[leftExtract]) % 256);
            leftInsert = (leftInsert + 1) % 15;
            leftExtract = (leftExtract + 1) % 15;
        }
    }

    protected void filterUp(byte[] pixels, int startPos, int width) {
        int nBytes = width * this.bytesPerPixel;
        for (int i = 0; i < nBytes; ++i) {
            byte currentByte = pixels[startPos + i];
            pixels[startPos + i] = (byte)((pixels[startPos + i] - this.priorRow[i]) % 256);
            this.priorRow[i] = currentByte;
        }
    }

    protected boolean writeImageData() {
        int startRow = 0;
        this.bytesPerPixel = this.encodeAlpha ? 4 : 3;
        Deflater scrunch = new Deflater(this.compressionLevel);
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream(1024);
        DeflaterOutputStream compBytes = new DeflaterOutputStream((OutputStream)outBytes, scrunch);
        try {
            int nRows;
            for (int rowsLeft = this.height; rowsLeft > 0; rowsLeft -= nRows) {
                nRows = Math.min(32767 / (this.width * (this.bytesPerPixel + 1)), rowsLeft);
                nRows = Math.max(nRows, 1);
                int[] pixels = new int[this.width * nRows];
                PixelGrabber pg = new PixelGrabber(this.image, 0, startRow, this.width, nRows, pixels, 0, this.width);
                try {
                    pg.grabPixels();
                }
                catch (Exception e) {
                    System.err.println("interrupted waiting for pixels!");
                    return false;
                }
                if ((pg.getStatus() & 128) != 0) {
                    System.err.println("image fetch aborted or errored");
                    return false;
                }
                byte[] scanLines = new byte[this.width * nRows * this.bytesPerPixel + nRows];
                if (this.filter == 1) {
                    this.leftBytes = new byte[16];
                }
                if (this.filter == 2) {
                    this.priorRow = new byte[this.width * this.bytesPerPixel];
                }
                int scanPos = 0;
                int startPos = 1;
                for (int i = 0; i < this.width * nRows; ++i) {
                    if (i % this.width == 0) {
                        scanLines[scanPos++] = (byte)this.filter;
                        startPos = scanPos;
                    }
                    scanLines[scanPos++] = (byte)(pixels[i] >> 16 & 255);
                    scanLines[scanPos++] = (byte)(pixels[i] >> 8 & 255);
                    scanLines[scanPos++] = (byte)(pixels[i] & 255);
                    if (this.encodeAlpha) {
                        scanLines[scanPos++] = (byte)(pixels[i] >> 24 & 255);
                    }
                    if (i % this.width != this.width - 1 || this.filter == 0) continue;
                    if (this.filter == 1) {
                        this.filterSub(scanLines, startPos, this.width);
                    }
                    if (this.filter != 2) continue;
                    this.filterUp(scanLines, startPos, this.width);
                }
                compBytes.write(scanLines, 0, scanPos);
                startRow += nRows;
            }
            compBytes.close();
            byte[] compressedLines = outBytes.toByteArray();
            int nCompressed = compressedLines.length;
            this.crc.reset();
            this.bytePos = this.writeInt4(nCompressed, this.bytePos);
            this.bytePos = this.writeBytes(IDAT, this.bytePos);
            this.crc.update(IDAT);
            this.bytePos = this.writeBytes(compressedLines, nCompressed, this.bytePos);
            this.crc.update(compressedLines, 0, nCompressed);
            this.crcValue = this.crc.getValue();
            this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
            scrunch.finish();
            scrunch.end();
            return true;
        }
        catch (IOException e) {
            System.err.println(e.toString());
            return false;
        }
    }

    protected void writeEnd() {
        this.bytePos = this.writeInt4(0, this.bytePos);
        this.bytePos = this.writeBytes(IEND, this.bytePos);
        this.crc.reset();
        this.crc.update(IEND);
        this.crcValue = this.crc.getValue();
        this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
    }

    public void setXDpi(int xDpi) {
        this.xDpi = Math.round((float)xDpi / INCH_IN_METER_UNIT);
    }

    public int getXDpi() {
        return Math.round((float)this.xDpi * INCH_IN_METER_UNIT);
    }

    public void setYDpi(int yDpi) {
        this.yDpi = Math.round((float)yDpi / INCH_IN_METER_UNIT);
    }

    public int getYDpi() {
        return Math.round((float)this.yDpi * INCH_IN_METER_UNIT);
    }

    public void setDpi(int xDpi, int yDpi) {
        this.xDpi = Math.round((float)xDpi / INCH_IN_METER_UNIT);
        this.yDpi = Math.round((float)yDpi / INCH_IN_METER_UNIT);
    }

    protected void writeResolution() {
        if (this.xDpi > 0 && this.yDpi > 0) {
            int startPos = this.bytePos = this.writeInt4(9, this.bytePos);
            this.bytePos = this.writeBytes(PHYS, this.bytePos);
            this.bytePos = this.writeInt4(this.xDpi, this.bytePos);
            this.bytePos = this.writeInt4(this.yDpi, this.bytePos);
            this.bytePos = this.writeByte(1, this.bytePos);
            this.crc.reset();
            this.crc.update(this.pngBytes, startPos, this.bytePos - startPos);
            this.crcValue = this.crc.getValue();
            this.bytePos = this.writeInt4((int)this.crcValue, this.bytePos);
        }
    }
}

