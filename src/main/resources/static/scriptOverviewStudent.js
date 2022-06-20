"use strict";

const listButton = document.querySelectorAll("#edit");
const listP = document.querySelectorAll("#studentEntity>p");
const listInput = document.querySelectorAll(
  "#studentEntity>input:not(.notVisible)"
);
const listSelect = document.querySelectorAll("#studentEntity>select");

//console.log(listButton);
//console.log(listP);
//console.log(listInput);

listButton.forEach((element, index) =>
  element.addEventListener("click", (e) => {
    if (window.getComputedStyle(listP[index * 5], null).display === "block") {
      e.preventDefault();

      element.innerHTML = "Save";
      listInput[index * 4].value = listP[index * 5].innerHTML;
      listInput[index * 4 + 1].value = listP[index * 5 + 1].innerHTML;
      listInput[index * 4 + 2].value = listP[index * 5 + 2].innerHTML;
      listInput[index * 4 + 3].value = listP[index * 5 + 3].innerHTML;
//      listSelect[index].value = listP[index * 5 + 4].innerHTML;

      listP[index * 5].style.display = "none";
      listP[index * 5 + 1].style.display = "none";
      listP[index * 5 + 2].style.display = "none";
      listP[index * 5 + 3].style.display = "none";
      listP[index * 5 + 4].style.display = "none";

      listInput[index * 4].style.display = "block";
      listInput[index * 4 + 1].style.display = "block";
      listInput[index * 4 + 2].style.display = "block";
      listInput[index * 4 + 3].style.display = "block";
      listSelect[index].style.display = "block";
    }
  })
);
///////////////////////////////////////////////////////////////////////////

//STUDENT TABLE SORT
const table = document.getElementById("studentTable");
[...table.rows[0].children].forEach((element, index) => {
  if (index < 5) {
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

//STUDENT TABLE SEARCH
let input, filter, tr, td, i, j, txtValue;
input = document.getElementById("searchInput");
tr = table.getElementsByTagName("tr");

// Loop through all table rows, and hide those who don't match the search query
input.addEventListener("keyup", () => {
  filter = input.value.toUpperCase();
  for (i = 1; i < tr.length; i++) {
    let valid = 0;
    for (j = 0; j < 5; j++) {
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
