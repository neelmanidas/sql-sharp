using System;
using System.Dynamic;
using System.Collections.Generic;

namespace SqlSharp
{
    public static class MainClass
    {
        public static void Main(string[] args)
        {
            using(var table = new TableReader("ejemplo.txt"))
            {
                Console.WriteLine("select * from ejemplo.txt");
                var result1 = table.AsDynamic();
                #region print
                result1.HandleResults(item => Console.WriteLine("{0} {1} {2} {3} {4} {5}", item.Nombre, item.Paterno, item.Materno, item.Edad, item.Grupo, item.Boleta));
                #endregion

                Console.WriteLine();

                Console.WriteLine("select * from ejemplo.txt where Edad > 18");
                var result2 = table
                    .AsDynamic()
                        .Where(item => Int32.Parse(item.Edad) > 18);
                #region print
                result2.HandleResults(item => Console.WriteLine("{0} {1} {2} {3} {4} {5}", item.Nombre, item.Paterno, item.Materno, item.Edad, item.Grupo, item.Boleta));
                #endregion

                Console.WriteLine();

                Console.WriteLine("select Nombre, Grupo from ejemplo.txt where Edad > 18 order asc by Nombre");
                var result3 = table
                    .AsDynamic()
                        .Where(item => Int32.Parse(item.Edad) > 18)
                        .Select(proy => new {Nombre = proy.Nombre,Grupo = proy.Grupo})
                        .OrderByAscending(sel => sel.Nombre);
                #region print
                result3.HandleResults(item => Console.WriteLine("{0} {1}", item.Nombre, item.Grupo));
                #endregion

                Console.WriteLine();

                Console.WriteLine("select Count(Grupo) as Inscritos, Grupo from ejemplo.txt group by Grupo where Inscritos > 1 order dsc by Inscritos");
                var result4 = table
                    .AsDynamic()
                        .GroupBy(item => item.Grupo)
                        .Select(grupo => new {Inscritos = grupo.Count(), Grupo = grupo.Key})
                        .Where(proy => proy.Inscritos > 1)
                        .OrderByDescending(p => p.Inscritos);
                #region print
                result4.HandleResults(item => Console.WriteLine("{0} {1}", item.Inscritos, item.Grupo));
                #endregion
            }
        }
    }
}