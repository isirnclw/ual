import 'package:flutter/material.dart';
import 'package:fplate/helpers/dataHelper.dart';
import 'package:fplate/helpers/enums.dart';
import 'package:fplate/views/items.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  static DataHelper data = new DataHelper();

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Contoso Smart',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: MyHomePage(title: 'Inicio'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<ItemGroup> groups = ItemGroup.values;
  Set<List<int>> colors = <List<int>>{
    <int>[0, 153, 221],
    <int>[170, 170, 170],
    <int>[68, 136, 255],
    <int>[238, 0, 0],
    <int>[204, 17, 85],
    <int>[0, 170, 238],
    <int>[119, 119, 119],
    <int>[238, 17, 34],
    <int>[17, 68, 153],
    <int>[238, 0, 34],
    <int>[0, 102, 51],
    <int>[0, 68, 170],
    <int>[0, 0, 0],
    <int>[255, 102, 0]
  };

  @override
  Widget build(BuildContext context) {
    int cCount = colors.length;

    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(title: Text(widget.title)),
      body: ListView.builder(
        padding: const EdgeInsets.only(bottom: 1),
        itemCount: groups.length - 2,
        itemBuilder: (BuildContext context, int i) {
          var color = colors.elementAt(i > cCount ? i % cCount : i);
          return GestureDetector(
            child: Container(
              padding: const EdgeInsets.symmetric(vertical: 25, horizontal: 12),
              child: Text('${groups[i + 2]}'.substring(10)),
              decoration: BoxDecoration(
                  color: Color.fromARGB(10, color[0], color[1], color[2]),
                  border: Border(
                      left: BorderSide(
                          color: Color.fromARGB(255, color[0], color[1], color[2]), width: 6))),
            ),
            onTap: () async => await DataHelper.getItemGroup(groups[i + 2])
                .then((value) => Navigator.push(context, MaterialPageRoute(builder: (context) {
                      return Items(groups[i + 2], value);
                    }))),
          );
        },
      ),
    );
  }
}
