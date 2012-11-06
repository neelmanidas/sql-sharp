namespace SqlSharp
{
	using System;
    using System.Collections.Generic;
    using System.Dynamic;
    using System.IO;

    public class TableReader : IEnumerable<ExpandoObject>, IDisposable
    {
        private string path;
        private StreamReader openStream;
        private bool disposed;

        public TableReader(string path)
        {
            this.path = path;
            this.disposed = false;
        }

        public IEnumerator<ExpandoObject> GetEnumerator()
        {
            openStream = File.OpenText(path);
            var names = openStream.ReadLine().Split(',');

            while(!openStream.EndOfStream && !disposed)
            {
                var properties = this.openStream.ReadLine().Split(',');

                yield return this.ParseObject(names, properties);
            }
        }

        public void Dispose()
        {
            this.openStream.Close();
            this.openStream.Dispose();
            this.disposed = true;
        }

        private ExpandoObject ParseObject(string[] names, string[] properties)
        {
            IDictionary<string, object> result = new ExpandoObject();

            for(int i = 0; i < names.Length; i++)
            {
                result.Add(names[i], properties[i]);
            }

            return (ExpandoObject)result;
        }

        System.Collections.IEnumerator System.Collections.IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }		
    }
}