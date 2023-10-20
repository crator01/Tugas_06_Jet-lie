Feature: User menggunakan filter

 Scenario: User ingin menggunkan filter
   Given User sudah berada di halaman home
   When User mengklik icon filter
    And memilih filter low to high
  Then Produk akan tersortir