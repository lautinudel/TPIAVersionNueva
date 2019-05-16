/*
 * Copyright 2007-2009 Georgina Stegmayer, Milagros Gutiérrez, Jorge Roa
 * y Milton Pividori.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package frsf.cidisi.faia.solver.search;

/**
 * This class is used by the InformedSearchStrategy constructors to set
 * a dummy estimated cost function when making a Greedy search object.
 */
public class DummyStepCostFunction implements IStepCostFunction {

    private static DummyStepCostFunction g;

    @Override
    public double calculateCost(NTree node) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static IStepCostFunction getInstance() {
        if (g == null) {
            g = new DummyStepCostFunction();
        }
        return g;
    }
}
