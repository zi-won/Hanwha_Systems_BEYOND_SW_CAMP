-- limit
SELECT
		 menu_code
	  , menu_name
	  , menu_price
  FROM tbl_menu
 ORDER BY menu_price DESC, menu_code DESC
 LIMIT 4, 3;