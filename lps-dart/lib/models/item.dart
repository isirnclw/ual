// To parse this JSON data, do
//
//     final item = itemFromJson(jsonString);

import 'dart:convert';

class Item {
  Item({
    this.id,
    this.idioma2,
    this.idioma1,
    this.imagen,
    this.nombre,
    this.caption,
    this.salida,
  });

  String id;
  String idioma2;
  String idioma1;
  String imagen;
  String nombre;
  String caption;
  DateTime salida;

  factory Item.fromRawJson(String str) => Item.fromJson(json.decode(str));

  String toRawJson() => json.encode(toJson());

  factory Item.fromJson(Map<String, dynamic> json) => Item(
        id: json["_id"],
        idioma2: json["Idioma2"] == null ? null : json["Idioma2"],
        idioma1: json["Idioma1"],
        imagen: json["Imagen"],
        nombre: json["Nombre"],
        caption: json["Caption"],
        salida: DateTime.parse(json["Salida"]),
      );

  Map<String, dynamic> toJson() => {
        "_id": id,
        "Idioma2": idioma2 == null ? null : idioma2,
        "Idioma1": idioma1,
        "Imagen": imagen,
        "Nombre": nombre,
        "Caption": caption,
        "Salida":
            "${salida.year.toString().padLeft(4, '0')}-${salida.month.toString().padLeft(2, '0')}-${salida.day.toString().padLeft(2, '0')}",
      };
}
