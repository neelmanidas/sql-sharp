namespace SqlSharp
{
	using System;
    using System.IO;
    using NUnit.Framework;
    using System.Collections.Generic;

    [TestFixture]
    public class DynamicQueriesTests
    {
        [Test]
        [Description("El número de objetos creados es el mismo que el número de tuplas en la tabla.")]
        public void T010()
        {
            var expected = File.OpenText("ejemplo.txt").ReadToEnd().Split('\n').Length - 1;
            var actual = new TableReader("ejemplo.txt").Count();

            Assert.AreEqual(expected, actual);
        }

        [Test]
        [Description("Por cada columna, cada objeto tiene una propiedad con el mismo nombre")]
        public void T020()
        {
            var names = File.OpenText("ejemplo.txt").ReadLine().Split(',');
            IEnumerable<IDictionary<string,object>> objects = new TableReader("ejemplo.txt");

            foreach(var item in objects)
            {
                var properties = item.Keys;
                Assert.AreEqual(names.Length, properties.Count, "La cantidad de propiedades y de nombres es distinta.");

                foreach(var name in names)
                {
                    Assert.IsTrue(properties.Contains(name), "El objeto creado no contiene la propiedad {0}", name);
                }
            }
        }
    }
}