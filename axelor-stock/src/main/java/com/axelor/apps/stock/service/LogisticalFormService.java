/*
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
package com.axelor.apps.stock.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.axelor.apps.stock.db.LogisticalForm;
import com.axelor.apps.stock.db.StockMove;
import com.axelor.apps.stock.db.StockMoveLine;
import com.axelor.apps.stock.exception.InconsistentLogisticalFormLines;
import com.axelor.apps.stock.exception.InvalidLogisticalFormLineDimensions;

public interface LogisticalFormService {

	/**
	 * Add detail lines from the stock move.
	 * 
	 * @param logisticalForm
	 * @param stockMove
	 */
	void addDetailLines(LogisticalForm logisticalForm, StockMove stockMove);

	/**
	 * Add parcel or pallet line.
	 * 
	 * @param logisticalForm
	 * @param typeSelect
	 */
	void addParcelPalletLine(LogisticalForm logisticalForm, int typeSelect);

	/**
	 * Compute totals.
	 * 
	 * @param logisticalForm
	 * @throws InvalidLogisticalFormLineDimensions
	 */
	void computeTotals(LogisticalForm logisticalForm) throws InvalidLogisticalFormLineDimensions;

	/**
	 * Check for inconsistent lines.
	 * 
	 * @param logisticalForm
	 * @throws InconsistentLogisticalFormLines
	 * @throws InvalidLogisticalFormLineDimensions
	 */
	void checkInconsistentLines(LogisticalForm logisticalForm) throws InconsistentLogisticalFormLines;

	/**
	 * Check for invalid dimensions in lines.
	 * 
	 * @param logisticalForm
	 * @throws InvalidLogisticalFormLineDimensions
	 */
	void checkInvalidLineDimensions(LogisticalForm logisticalForm) throws InvalidLogisticalFormLineDimensions;

	/**
	 * Get list of full spread stock move lines.
	 * 
	 * @param logisticalForm
	 * @return
	 */
	List<StockMoveLine> getFullySpreadStockMoveLineList(LogisticalForm logisticalForm);

	/**
	 * Get map of spread quantity for each stock move line.
	 * 
	 * @param logisticalForm
	 * @return
	 */
	Map<StockMoveLine, BigDecimal> getStockMoveLineQtyMap(LogisticalForm logisticalForm);

	/**
	 * Get domain for stock move.
	 * 
	 * @param logisticalForm
	 * @return
	 */
	String getStockMoveDomain(LogisticalForm logisticalForm);

	/**
	 * Find highest parcel/pallet number
	 * 
	 * @param logisticalForm
	 * @param typeSelect
	 * @return
	 */
	int findHighestParcelPalletNumber(LogisticalForm logisticalForm, int typeSelect);

}
