/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2017 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.stock.web;

import com.axelor.apps.stock.db.StockMove;
import com.axelor.apps.stock.db.StockMoveLine;
import com.axelor.apps.stock.service.StockMoveLineService;
import com.axelor.exception.AxelorException;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class StockMoveLineController {
	
	@Inject
	protected StockMoveLineService stockMoveLineService;
	
	public void compute(ActionRequest request, ActionResponse response) throws AxelorException {
		StockMoveLine stockMoveLine = request.getContext().asType(StockMoveLine.class);
		StockMove stockMove = stockMoveLine.getStockMove();
		if(stockMove == null){
			stockMove = request.getContext().getParentContext().asType(StockMove.class);
		}
		stockMoveLine.getStockMove();
		stockMoveLine = stockMoveLineService.compute(stockMoveLine, stockMove);
		response.setValue("unitPriceUntaxed", stockMoveLine.getUnitPriceUntaxed());
		response.setValue("unitPriceTaxed", stockMoveLine.getUnitPriceTaxed());
	}
}
