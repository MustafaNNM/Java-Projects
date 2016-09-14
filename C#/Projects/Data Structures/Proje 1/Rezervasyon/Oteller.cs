using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Rezervasyon
{
    public class Oteller
    {
        public Oteller(int n)
        {
                oteller= new Queue<Otel>(n);
        }

        public Queue<Otel> oteller
        {
            get
            {
                return oteller;
            }
            set
            {
                oteller = value;
            }
        }
    }
}
