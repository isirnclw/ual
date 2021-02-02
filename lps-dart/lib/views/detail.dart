import 'package:flutter/material.dart';
import 'package:flutter_html/flutter_html.dart';
import 'package:fplate/models/item.dart';

class Detail extends StatelessWidget {
  static Item item;

  Detail(Item i) {
    item = i;
  }

  @override
  Widget build(BuildContext context) {
    print(item.idioma1);
    return Scaffold(
      appBar: AppBar(title: Text(item.nombre)),
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          mainAxisSize: MainAxisSize.min,
          children: <Widget>[
            Image.network(
              item.imagen,
              errorBuilder: (context, error, stackTrace) => Container(
                height: 60,
                child: Center(child: Text('Whoops!')),
              ),
            ),
            Padding(
              padding: EdgeInsets.symmetric(horizontal: 20),
              child: Container(
                height: 1,
                color: Colors.blue,
              ),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(20, 20, 20, 40),
              child: Html(data: item.idioma1),
            ),
          ],
        ),
      ),
    );
  }
}
