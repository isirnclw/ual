using System.Text;
using System.Threading.Tasks;
using Windows.Storage;
using static System.IO.File;

namespace Odin.Helpers
{
    public class DataHelper
    {
        public static readonly StorageFolder Folder = ApplicationData.Current.RoamingFolder;

        public static string Read(string name)
        {
            string path = $"{Folder.Path}\\{name}";
            return Exists(path) ? ReadAllText(path) : string.Empty;
        }

        public static async Task<bool> SaveAs(string name, string json)
        {
            string file = $"{Folder.Path}\\{name}";

            byte[] byteA = Encoding.UTF8.GetBytes(json);

            using System.IO.FileStream fileStream = Create(file);
            await fileStream.WriteAsync(byteA, 0, byteA.Length);

            return Exists(file);
        }

        public void InitializeKey(string key, object defaultValue)
        {
            if (!ApplicationData.Current.RoamingSettings.Values.ContainsKey(key))
            {
                ApplicationData.Current.RoamingSettings.Values.Add(key, defaultValue);
            }
        }
    }
}
