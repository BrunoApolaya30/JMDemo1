//* Modal
//* Categoria
((d) => {
  const txtcategoria = ["id", "name", "descripcion"];

  const $editcategoria = d.querySelectorAll("#editcategoria"),
    $vercategoria = d.querySelectorAll("#vercategoria"),
    $eliminarcategoria = d.querySelectorAll("#eliminarcategoria"),
    $deletecategoria = d.getElementById("deletecategoria"),
    $limpiarcategoria = d.getElementById("categorialimpiar"),
    $buscar = d.getElementById("search"),
    $select = d.getElementById("select");
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
    });
  });
  $eliminarcategoria.forEach((el) => {
    el.addEventListener("click", (e) => {
      $deletecategoria.dataset.id = el.dataset.id;
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
    }
    // Eliminación
    if (e.target.matches("#deletecategoria")) {
      window.location.href = `/categoria/eliminar/${e.target.dataset.id}`;
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
