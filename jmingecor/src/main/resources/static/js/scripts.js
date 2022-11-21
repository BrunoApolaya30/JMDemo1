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
    txtalmacen = ["id", "ubicacion", "descripcion"];
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
    $limpiaralmacen = d.getElementById("limpiaralmacen");
  ($buscar = d.getElementById("search")),
    ($select = d.getElementById("select"));
  if ($limpiarcategoria) {
    $limpiarcategoria.addEventListener("click", (e) => {
      txtcategoria.forEach((ele) => {
        d.getElementById(ele).value = "";
      });
    });
  }

  $editcategoria.forEach((el) => {
    el.addEventListener("click", () => {
      txtcategoria.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
      });
      $limpiarcategoria.style = "display:block";
    });
  });

  $vercategoria.forEach((el) => {
    el.addEventListener("click", () => {
      txtcategoria.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER CATEGORIA";
      d.getElementById("btn-guardar").style = "display : none";
      $limpiarcategoria.style = "display : none";
    });
  });
  $eliminarcategoria.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletecategoria.dataset.id = el.dataset.id;
    });
  });

  //*Equipo

  if ($limpiarequipo) {
    $limpiarequipo.addEventListener("click", (e) => {
      txtequipo.forEach((ele) => {
        d.getElementById(ele).value = "";
      });
    });
  }

  $editequipo.forEach((el) => {
    el.addEventListener("click", () => {
      txtequipo.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarequipo.style = "display:block";
    });
  });

  $verequipo.forEach((el) => {
    el.addEventListener("click", () => {
      txtequipo.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "Ver Equipo";
      d.getElementById("btn-guardar").style = "display : none";
      $limpiarequipo.style = "display : none";
    });
  });
  $eliminarequipo.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deleteequipo.dataset.id = el.dataset.id;
    });
  });

  //*Material

  if ($limpiarmaterial) {
    $limpiarmaterial.addEventListener("click", (e) => {
      txtmaterial.forEach((ele) => {
        d.getElementById(ele).value = "";
      });
    });
  }

  $editmaterial.forEach((el) => {
    el.addEventListener("click", () => {
      txtmaterial.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarmaterial.style = "display:block";
    });
  });

  $vermaterial.forEach((el) => {
    el.addEventListener("click", () => {
      txtmaterial.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "VER MATERIAL";
      d.getElementById("btn-guardar").style = "display : none";
      $limpiarmaterial.style = "display : none";
    });
  });
  $eliminarmaterial.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletematerial.dataset.id = el.dataset.id;
    });
  });

  //*Jornales

  if ($limpiarjornales) {
    $limpiarjornales.addEventListener("click", (e) => {
      txtjornales.forEach((ele) => {
        d.getElementById(ele).value = "";
      });
    });
  }

  $editjornales.forEach((el) => {
    el.addEventListener("click", () => {
      txtjornales.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiarjornales.style = "display:block";
    });
  });

  $verjornales.forEach((el) => {
    el.addEventListener("click", () => {
      txtjornales.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "Ver Jornales";
      d.getElementById("btn-guardar").style = "display : none";
      $limpiarjornales.style = "display : none";
    });
  });
  $eliminarjornales.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletejornales.dataset.id = el.dataset.id;
    });
  });

  //*Almacen

  if ($limpiaralmacen) {
    $limpiaralmacen.addEventListener("click", (e) => {
      txtalmacen.forEach((ele) => {
        d.getElementById(ele).value = "";
      });
    });
  }

  $editalmacen.forEach((el) => {
    el.addEventListener("click", () => {
      txtalmacen.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
      });
      d.getElementById("btn-guardar").style = "display : block";
      $limpiaralmacen.style = "display:block";
    });
  });

  $veralmacen.forEach((el) => {
    el.addEventListener("click", () => {
      txtalmacen.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = "Ver Almacenes";
      d.getElementById("btn-guardar").style = "display : none";
      $limpiaralmacen.style = "display : none";
    });
  });
  $eliminaralmacen.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletealmacen.dataset.id = el.dataset.id;
    });
  });

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
