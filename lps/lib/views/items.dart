import 'package:flutter/material.dart';
import 'package:fplate/helpers/enums.dart';
import 'package:fplate/models/item.dart';
import 'package:fplate/views/detail.dart';

class Items extends StatelessWidget {
  static List<Item> items;
  static ItemGroup group;
  static String title;

  Items(ItemGroup g, List<Item> i) {
    group = g;
    title = group.toString().substring(10);
    items = i;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(title)),
      body: ListView.builder(
        padding: const EdgeInsets.only(bottom: 1),
        itemCount: items.length,
        itemBuilder: (BuildContext context, int i) {
          return Container(
              height: 120,
              child: GestureDetector(
                child: Row(
                  children: <Widget>[
                    Image.network(
                      items.elementAt(i).imagen,
                      height: 120,
                      width: 120,
                      errorBuilder: (context, error, stackTrace) => Container(
                        height: 120,
                        width: 120,
                        child: Center(child: Text('Whoops!')),
                      ),
                    ),
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      mainAxisSize: MainAxisSize.min,
                      children: <Widget>[
                        Container(
                          margin: EdgeInsets.only(top: 12),
                          height: 26,
                          child: Text(items.elementAt(i).nombre,
                              style: DefaultTextStyle.of(context)
                                  .style
                                  .apply(fontSizeFactor: 1.25, fontWeightDelta: 1)),
                        ),
                        Container(
                          height: 80,
                          width: MediaQuery.of(context).size.width - 140,
                          child: Text(items.elementAt(i).caption, maxLines: 4),
                        ),
                      ],
                    ),
                  ],
                ),
                onTap: () => Navigator.push(context, MaterialPageRoute(builder: (context) {
                  return Detail(items.elementAt(i));
                })),
              ));
        },
      ),
    );
  }
}
