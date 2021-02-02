using System.Collections.Generic;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Linq;
using ColChanged = System.Collections.Specialized.NotifyCollectionChangedEventArgs;
using PropChanged = System.ComponentModel.PropertyChangedEventArgs;

namespace Odin.Helpers
{
    public class ObservableDictionary<TKey, TValue> : Dictionary<TKey, TValue>, INotifyCollectionChanged, INotifyPropertyChanged
    {
        public new TValue this[TKey key]
        {
            get => base[key];
            set
            {
                bool exist = TryGetValue(key, out TValue oldValue);
                KeyValuePair<TKey, TValue> oldItem = new KeyValuePair<TKey, TValue>(key, oldValue), newItem;

                base[key] = value;
                newItem = new KeyValuePair<TKey, TValue>(key, value);

                if (exist)
                {
                    OnCollectionChanged(new ColChanged(NotifyCollectionChangedAction.Replace, newItem, oldItem, Keys.ToList().IndexOf(key)));
                }
                else
                {
                    OnCollectionChanged(new ColChanged(NotifyCollectionChangedAction.Add, newItem, Keys.ToList().IndexOf(key)));
                    OnPropertyChanged(new PropChanged(nameof(Count)));
                }
            }
        }

        public event NotifyCollectionChangedEventHandler CollectionChanged;

        public event PropertyChangedEventHandler PropertyChanged;

        public new void Add(TKey key, TValue value)
        {
            if (!ContainsKey(key))
            {
                KeyValuePair<TKey, TValue> item = new KeyValuePair<TKey, TValue>(key, value);

                base.Add(key, value);
                OnCollectionChanged(new ColChanged(NotifyCollectionChangedAction.Add, item, Keys.ToList().IndexOf(key)));
                OnPropertyChanged(new PropChanged(nameof(Count)));
            }
        }

        public new void Clear()
        {
            base.Clear();
            OnCollectionChanged(new ColChanged(NotifyCollectionChangedAction.Reset));
            OnPropertyChanged(new PropChanged(nameof(Count)));
        }

        public new bool Remove(TKey key)
        {
            if (TryGetValue(key, out _))
            {
                KeyValuePair<TKey, TValue> item = new KeyValuePair<TKey, TValue>(key, base[key]);
                bool result = base.Remove(key);

                OnCollectionChanged(new ColChanged(NotifyCollectionChangedAction.Remove, item, Keys.ToList().IndexOf(key)));
                OnPropertyChanged(new PropChanged(nameof(Count)));

                return result;
            }
            return false;
        }

        protected virtual void OnCollectionChanged(ColChanged e)
        {
            CollectionChanged?.Invoke(this, e);
        }

        protected virtual void OnPropertyChanged(PropChanged e)
        {
            PropertyChanged?.Invoke(this, e);
        }
    }
}
