export function limpiar(d, limpiado, txt) {
  limpiado.addEventListener("click", (e) => {
    txt.forEach((ele) => {
      d.getElementById(ele).value = "";
    });
  });
}
export function editado(d, editado, txt, limpiado) {
  editado.forEach((el) => {
    el.addEventListener("click", () => {
      txt.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = false;
      });
      limpiado.style = "display:block";
    });
  });
}
export function ver(d, visto, txt, limpiado, texto) {
  visto.forEach((el) => {
    el.addEventListener("click", () => {
      txt.forEach((ele) => {
        d.getElementById(ele).value = eval(`el.dataset.${ele}`);
        d.getElementById(ele).disabled = true;
      });
      d.getElementById("exampleModalLabel").textContent = `Ver ${texto}`;
      d.getElementById("btn-guardar").style = "display : none";
      limpiado.style = "display : none";
    });
  });
}
export function eliminado(eliminado, eliminadoconfirmado) {
  eliminado.forEach((el) => {
    el.addEventListener("click", (e) => {
      eliminadoconfirmado.dataset.id = el.dataset.id;
    });
  });
}
