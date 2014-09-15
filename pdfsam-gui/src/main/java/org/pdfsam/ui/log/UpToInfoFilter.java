/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 15/set/2014
 * Copyright 2013-2014 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.ui.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.filter.AbstractMatcherFilter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Logback filter to filter out WARN and above level logging events
 * 
 * @author Andrea Vacondio
 *
 */
public class UpToInfoFilter extends AbstractMatcherFilter<LoggingEvent> {

    @Override
    public FilterReply decide(LoggingEvent loggingEvent) {
        if (!(isStarted() && loggingEvent.getLevel().isGreaterOrEqual(Level.WARN))) {
            return FilterReply.NEUTRAL;
        }
        return FilterReply.DENY;
    }

}