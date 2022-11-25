import { limpiar, editado, ver, eliminado } from "./helpers.js";

//* Modal
//* Categoria
((d) => {
  const txtcategoria = ["id", "name", "descripcion"],
    txtequipo = [
      "id",
      "name",
      "descripcion",
      "categoria",
      "fecha",
      "cantidad",
      "peso",
      "pesototal",
      "alquiler",
      "observaciones",
    ],
    txtmaterial = [
      "id",
      "name",
      "categoria",
      "precio",
      "lugar_compra_material",
      "igv_material",
      "precio_obra_material",
    ],
    txtjornales = ["id", "unidad", "costo", "categoria"],
    txtalmacen = ["id", "ubicacion", "descripcion"],
    txtpersonal = [
      "id",
      "name",
      "apellidos",
      "cargo",
      "dni",
      "direccion",
      "telefono",
      "correo",
    ],
    txtcliente = [
      "id",
      "documento_ruc",
      "nombre_rz",
      "direccion",
      "correo",
      "telefono",
      "estado",
      "fecha",
    ],
    txtcontactocampo = ["id", "empresa", "cargo_empresa", "telefono", "correo"],
    txtusuario = [
      "id",
      "documento",
      "nombre_completo",
      "cargo",
      "correo",
      "clave",
      "estado",
      "fecha_registro",
    ];
  const $editcategoria = d.querySelectorAll("#editcategoria"),
    $vercategoria = d.querySelectorAll("#vercategoria"),
    $eliminarcategoria = d.querySelectorAll("#eliminarcategoria"),
    $deletecategoria = d.getElementById("deletecategoria"),
    $limpiarcategoria = d.getElementById("limpiarcategoria"),
    $editequipo = d.querySelectorAll("#editequipo"),
    $verequipo = d.querySelectorAll("#verequipo"),
    $eliminarequipo = d.querySelectorAll("#eliminarequipo"),
    $deleteequipo = d.getElementById("deleteequipo"),
    $limpiarequipo = d.getElementById("limpiarequipo"),
    $editmaterial = d.querySelectorAll("#editmaterial"),
    $vermaterial = d.querySelectorAll("#vermaterial"),
    $eliminarmaterial = d.querySelectorAll("#eliminarmaterial"),
    $deletematerial = d.getElementById("deletematerial"),
    $limpiarmaterial = d.getElementById("limpiarmaterial"),
    $editjornales = d.querySelectorAll("#editjornales"),
    $verjornales = d.querySelectorAll("#verjornales"),
    $eliminarjornales = d.querySelectorAll("#eliminarjornales"),
    $deletejornales = d.getElementById("deletejornales"),
    $limpiarjornales = d.getElementById("limpiarjornales"),
    $editalmacen = d.querySelectorAll("#editalmacen"),
    $veralmacen = d.querySelectorAll("#veralmacen"),
    $eliminaralmacen = d.querySelectorAll("#eliminaralmacen"),
    $deletealmacen = d.getElementById("deletealmacen"),
    $limpiaralmacen = d.getElementById("limpiaralmacen"),
    $editpersonal = d.querySelectorAll("#editpersonal"),
    $verpersonal = d.querySelectorAll("#verpersonal"),
    $eliminarpersonal = d.querySelectorAll("#eliminarpersonal"),
    $deletepersonal = d.getElementById("deletepersonal"),
    $limpiarpersonal = d.getElementById("limpiarpersonal"),
    $editcliente = d.querySelectorAll("#editcliente"),
    $vercliente = d.querySelectorAll("#vercliente"),
    $eliminarcliente = d.querySelectorAll("#eliminarcliente"),
    $deletecliente = d.getElementById("deletecliente"),
    $limpiarcliente = d.getElementById("limpiarcliente"),
    $editcontactocampo = d.querySelectorAll("#editcontactocampo"),
    $vercontactocampo = d.querySelectorAll("#vercontactocampo"),
    $eliminarcontactocampo = d.querySelectorAll("#eliminarcontactocampo"),
    $deletecontactocampo = d.getElementById("deletecontactocampo"),
    $limpiarcontactocampo = d.getElementById("limpiarcontactocampo"),
    $editusuario = d.querySelectorAll("#editusuario"),
    $verusuario = d.querySelectorAll("#verusuario"),
    $eliminarusuario = d.querySelectorAll("#eliminarusuario"),
    $deleteusuario = d.getElementById("deleteusuario"),
    $limpiarusuario = d.getElementById("limpiarusuario"),
    $buscar = d.getElementById("search"),
    $select = d.getElementById("select");

  //*Categoria
  if ($limpiarcategoria) {
    limpiar(d, $limpiarcategoria, txtcategoria);
  }
  editado(d, $editcategoria, txtcategoria, $limpiarcategoria);

  ver(d, $vercategoria, txtcategoria, $limpiarcategoria, "Categoria");

  eliminado($eliminarcategoria, $deletecategoria);

  //*Equipo
  if ((d, $limpiarequipo)) {
    limpiar(d, $limpiarequipo, txtequipo);
  }
  editado(d, $editequipo, txtequipo, $limpiarequipo);

  ver(d, $verequipo, txtequipo, $limpiarequipo, "Equipo");

  eliminado($eliminarequipo, $deleteequipo);

  //*Material

  if ((d, $limpiarmaterial)) {
    limpiar(d, $limpiarmaterial, txtmaterial);
  }
  editado(d, $editmaterial, txtmaterial, $limpiarmaterial);

  ver(d, $vermaterial, txtmaterial, $limpiarmaterial, "Material");

  eliminado($eliminarmaterial, $deletematerial);

  //*Jornales

  if ((d, $limpiarjornales)) {
    limpiar(d, $limpiarjornales, txtjornales);
  }
  editado(d, $editjornales, txtjornales, $limpiarjornales);

  ver(d, $verjornales, txtjornales, $limpiarjornales, "Jornal");

  eliminado($eliminarjornales, $deletejornales);

  //*Almacen

  if ((d, $limpiaralmacen)) {
    limpiar(d, $limpiaralmacen, txtalmacen);
  }
  editado(d, $editalmacen, txtalmacen, $limpiaralmacen);

  ver(d, $veralmacen, txtalmacen, $limpiaralmacen, "Almacen");

  eliminado($eliminaralmacen, $deletealmacen);

  //*Personal
  if ((d, $limpiarpersonal)) {
    limpiar(d, $limpiarpersonal, txtpersonal);
  }
  editado(d, $editpersonal, txtpersonal, $limpiarpersonal);

  ver(d, $verpersonal, txtpersonal, $limpiarpersonal, "Personal");

  eliminado($eliminarpersonal, $deletepersonal);

  //*ContactoCampo
  if ((d, $limpiarcontactocampo)) {
    limpiar(d, $limpiarcontactocampo, txtcontactocampo);
  }
  editado(d, $editcontactocampo, txtcontactocampo, $limpiarcontactocampo);

  ver(
    d,
    $vercontactocampo,
    txtcontactocampo,
    $limpiarcontactocampo,
    "Contacto Campo"
  );

  eliminado($eliminarcontactocampo, $deletecontactocampo);

  //*Cliente
  if ((d, $limpiarcliente)) {
    limpiar(d, $limpiarcliente, txtcliente);
  }
  editado(d, $editcliente, txtcliente, $limpiarcliente);

  ver(d, $vercliente, txtcliente, $limpiarcliente, "Cliente");

  eliminado($eliminarcliente, $deletecliente);

  //*Usuario
  if ((d, $limpiarusuario)) {
    limpiar(d, $limpiarusuario, txtusuario);
  }
  editado(d, $editusuario, txtusuario, $limpiarusuario);

  ver(d, $verusuario, txtusuario, $limpiarusuario, "Usuario");

  eliminado($eliminarusuario, $deleteusuario);

  // **Enviar Registros Paginación
  $select.addEventListener("change", (e) => {
    let a = window.location.href;
    let go = a.split("/");
    let num = $select.value;
    const path = "/" + go[3] + "/?numPage=" + num;
    console.log(path);
    window.location.href = path;
  });
  d.addEventListener("click", (e) => {
    if (
      e.target.matches("#agregarcategoria") ||
      e.target.matches("#iconcategoria")
    ) {
      txtcategoria.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarcategoria.style = "display:block";
    }
    if (e.target.matches("#agregarequipo") || e.target.matches("#iconequipo")) {
      txtequipo.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarequipo.style = "display:block";
    }
    if (
      e.target.matches("#agregarmaterial") ||
      e.target.matches("#iconmaterial")
    ) {
      txtmaterial.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarmaterial.style = "display:block";
    }

    if (
      e.target.matches("#agregarjornales") ||
      e.target.matches("#iconjornales")
    ) {
      txtjornales.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarjornales.style = "display:block";
    }

    if (
      e.target.matches("#agregaralmacen") ||
      e.target.matches("#iconalmacen")
    ) {
      txtalmacen.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiaralmacen.style = "display:block";
    }

    if (
      e.target.matches("#agregarpersonal") ||
      e.target.matches("#iconpersonal")
    ) {
      txtpersonal.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarpersonal.style = "display:block";
    }

    if (
      e.target.matches("#agregarcliente") ||
      e.target.matches("#iconcliente")
    ) {
      txtcliente.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarcliente.style = "display:block";
    }

    if (
      e.target.matches("#agregarcontactocampo") ||
      e.target.matches("#iconcontactocampo")
    ) {
      txtcontactocampo.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarcontactocampo.style = "display:block";
    }

    if (
      e.target.matches("#agregarusuario") ||
      e.target.matches("#iconusuario")
    ) {
      txtusuario.forEach((el) => {
        d.getElementById(el).value = "";
        d.getElementById(el).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarusuario.style = "display:block";
    }

    // Eliminación
    if (e.target.matches("#deletecategoria")) {
      window.location.href = `/categoria/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deleteequipo")) {
      window.location.href = `/equipo/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletematerial")) {
      window.location.href = `/material/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletejornales")) {
      window.location.href = `/jornales/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletealmacen")) {
      window.location.href = `/almacen/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletepersonal")) {
      window.location.href = `/personal/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletecliente")) {
      window.location.href = `/cliente/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deletecontactocampo")) {
      window.location.href = `/contactocampo/eliminar/${e.target.dataset.id}`;
    }
    if (e.target.matches("#deleteusuario")) {
      window.location.href = `/usuario/eliminar/${e.target.dataset.id}`;
    }
  });
  // * Buscar
  let $names = Array.from(d.querySelectorAll("[data-nombre]"));
  console.log($names);
  if ($buscar) {
    $buscar.addEventListener("keyup", (e) => {
      let value = e.target.value.toLowerCase();
      console.log(value);

      if (value == "") {
        for (const name of $names) {
          console.log("HH");
          name.parentElement.style.display = "table-row";
          console.log(name.parentElement);
        }
      } else {
        for (const name of $names) {
          console.log("sdssd");
          console.log(name.dataset.nombre + "->>" + value);
          name.dataset.nombre.toLowerCase().indexOf(value) == -1
            ? (name.parentElement.style.display = "none")
            : (name.parentElement.style.display = "table-row");
        }
      }
    });
  }
})(document);
