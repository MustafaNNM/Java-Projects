using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Sanal_sayılar
{
    class Sanal_sayı<T>
    {
        private T cos;
        private T sin;

        public Sanal_sayı(T cos, T sin)
        {
            // TODO: Complete member initialization
            this.cos = cos;
            this.sin = sin;
        }
    }
}
