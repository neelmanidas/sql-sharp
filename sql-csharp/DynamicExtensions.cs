namespace SqlSharp
{
	using System;
    using System.Dynamic;
    using System.Collections.Generic;

    public static class DynamicExtensions
    {
        public static int Count <TSource>(this IEnumerable<TSource> source)
        {
            var count = 0;

            foreach(var item in source)
            {
                count ++;
            }

            return count;
        }

        public static double Sum(this IEnumerable<dynamic> source)
        {
            var sum = 0;
            foreach(var item in source)
            {
                sum += Double.Parse(item);
            }

            return sum;
        }

        public static double Sum <TSource>(this IEnumerable<TSource> source, Func<TSource, dynamic> keySelector)
        {
            var sum = 0;
            foreach(var item in source)
            {
                sum += Double.Parse(keySelector(item));
            }
            
            return sum;
        }

        public static IEnumerable<TSource> Where <TSource>(this IEnumerable<TSource> source, Func<TSource, bool> predicate)
        {
            foreach(var item in source)
            {
                if(predicate(item))
                {
                    yield return item;
                }
            }
        }

        public static IEnumerable<TSelector> Select <TSource, TSelector>(this IEnumerable<TSource> source, Func<TSource, TSelector> keySelector)
        {
            foreach(var item in source)
            {
                yield return keySelector(item);
            }
        }

        public static System.Linq.IOrderedEnumerable<TSource> OrderByAscending <TSource, TSelector>(this IEnumerable<TSource> source, Func<TSource, TSelector> keySelector)
        {
            return System.Linq.Enumerable.OrderBy(source, keySelector);
        }

        public static System.Linq.IOrderedEnumerable<TSource> OrderByDescending <TSource, TSelector>(this IEnumerable<TSource> source, Func<TSource, TSelector> keySelector)
        {
            return System.Linq.Enumerable.OrderByDescending(source, keySelector);
        }

        public static IEnumerable<System.Linq.IGrouping<TSelector, TSource>> GroupBy <TSource, TSelector>(this IEnumerable<TSource> source, Func<TSource, TSelector> keySelector)
        {
            return System.Linq.Enumerable.GroupBy(source, keySelector);
        }

        public static IEnumerable<dynamic> AsDynamic <TSource>(this IEnumerable<TSource> source)
        {
            foreach(var item in source)
            {
                yield return item;
            }
        }

        public static void HandleResults <TSource>(this IEnumerable<TSource> source, Action<TSource> action)
        {
            foreach(var item in source)
            {
                action(item);
            }
        }
    }	
}