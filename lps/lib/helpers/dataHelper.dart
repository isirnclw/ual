import 'dart:convert';
import 'package:fplate/models/item.dart';
import 'enums.dart';
import 'dart:async';
import 'package:flutter/services.dart' show rootBundle;

class DataHelper {
  static Map<ItemGroup, List<Item>> items = new Map<ItemGroup, List<Item>>();

  static Future<List<Item>> getItemGroup(ItemGroup group) async {
    String json = await rootBundle.loadString("assets/" + group.toString().substring(10) + ".json");

    items.putIfAbsent(group, () => List<Item>.from(jsonDecode(json).map((x) => Item.fromJson(x))));

    return items[group];
  }
}
