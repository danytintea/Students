"use strict";

const listaButoane = document.querySelectorAll("#edit");
const listaP = document.querySelectorAll("#majorEntity>p");
const listaInput = document.querySelectorAll(
  "#majorEntity>input:not(#notVisibleId)"
);

//console.log(listaButoane);
//console.log(listaP);
//console.log(listaInput);

listaButoane.forEach((element, index) =>
  element.addEventListener("click", (e) => {
    if (window.getComputedStyle(listaP[index * 4], null).display === "block") {
      e.preventDefault();

      element.innerHTML = "Save";
      listaInput[index * 4].value = listaP[index * 4].innerHTML;
      listaInput[index * 4 + 1].value = listaP[index * 4 + 1].innerHTML;
      listaInput[index * 4 + 2].value = listaP[index * 4 + 2].innerHTML;
      listaInput[index * 4 + 3].value = listaP[index * 4 + 3].innerHTML;

      listaP[index * 4].style.display = "none";
      listaP[index * 4 + 1].style.display = "none";
      listaP[index * 4 + 2].style.display = "none";
      listaP[index * 4 + 3].style.display = "none";

      listaInput[index * 4].style.display = "block";
      listaInput[index * 4 + 1].style.display = "block";
      listaInput[index * 4 + 2].style.display = "block";
      listaInput[index * 4 + 3].style.display = "block";
    }
  })
);
///////////////////////////////////////////////////////////////////////////

//SPECIALIZARE TABLE SORT
const table = document.getElementById("majorTable");
[...table.rows[0].children].forEach((element, index) => {
  if (index < 4) {
    element.style.cursor = "pointer";
    element.addEventListener("click", (e) => {
      let rows,
        switching,
        i,
        x,
        y,
        shouldSwitch,
        dir,
        switchcount = 0;
      switching = true;
      // Set the sorting direction to ascending:
      dir = "asc";
      /* Make a loop that will continue until
    no switching has been done: */
      while (switching) {
        // Start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /* Loop through all table rows (except the
      first, which contains table headers): */
        for (i = 1; i < rows.length - 1; i++) {
          // Start by saying there should be no switching:
          shouldSwitch = false;
          /* Get the two elements you want to compare,
        one from current row and one from the next: */
          x = rows[i].getElementsByTagName("TD")[index];
          y = rows[i + 1].getElementsByTagName("TD")[index];
          /* Check if the two rows should switch place,
        based on the direction, asc or desc: */
          if (dir == "asc") {
            if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
              // If so, mark as a switch and break the loop:
              shouldSwitch = true;
              break;
            }
          } else if (dir == "desc") {
            if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
              // If so, mark as a switch and break the loop:
              shouldSwitch = true;
              break;
            }
          }
        }
        if (shouldSwitch) {
          /* If a switch has been marked, make the switch
        and mark that a switch has been done: */
          rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
          switching = true;
          // Each time a switch is done, increase this count by 1:
          switchcount++;
        } else {
          /* If no switching has been done AND the direction is "asc",
        set the direction to "desc" and run the while loop again. */
          if (switchcount == 0 && dir == "asc") {
            dir = "desc";
            switching = true;
          }
        }
      }
    });
  }
});
///////////////////////////////////////////////////////////////////////////

//SPECIALIZARE TABLE SEARCH
let input, filter, tr, td, i, j, txtValue;
input = document.getElementById("searchInput");
tr = table.getElementsByTagName("tr");

// Loop through all table rows, and hide those who don't match the search query
input.addEventListener("keyup", () => {
  filter = input.value.toUpperCase();
  for (i = 1; i < tr.length; i++) {
    let valid = 0;
    for (j = 0; j < 4; j++) {
      td = tr[i].getElementsByTagName("td")[j];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          valid++;
        }
      }
    }
    if (valid > 0) {
      tr[i].style.display = "";
    } else {
      tr[i].style.display = "none";
    }
  }
});
