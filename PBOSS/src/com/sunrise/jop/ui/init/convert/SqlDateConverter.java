/**
 * 
 */
package com.sunrise.jop.ui.init.convert;

import java.sql.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/**
 * <p>
 * Standard {@link Converter} implementation that converts an incoming String
 * into a <code>java.sql.Date</code> object, optionally using a default value
 * or throwing a {@link ConversionException} if a conversion error occurs.
 * </p>
 * 
 * @author Craig R. McClanahan
 * @version $Revision: 1.1 $ $Date: 2006/08/31 13:04:29 $
 * @since 1.3
 */

public final class SqlDateConverter implements Converter {

	// ----------------------------------------------------------- Constructors

	/**
	 * Create a {@link Converter} that will throw a {@link ConversionException}
	 * if a conversion error occurs.
	 */
	public SqlDateConverter() {

		this.defaultValue = null;
		this.useDefault = false;

	}

	/**
	 * Create a {@link Converter} that will return the specified default value
	 * if a conversion error occurs.
	 * 
	 * @param defaultValue
	 *            The default value to be returned
	 */
	public SqlDateConverter(Object defaultValue) {

		this.defaultValue = defaultValue;
		this.useDefault = true;

	}

	// ----------------------------------------------------- Instance Variables

	/**
	 * The default value specified to our Constructor, if any.
	 */
	private Object defaultValue = null;

	/**
	 * Should we return the default value on conversion errors?
	 */
	private boolean useDefault = true;

	// --------------------------------------------------------- Public Methods

	/**
	 * Convert the specified input object into an output object of the specified
	 * type.
	 * 
	 * @param type
	 *            Data type to which this value should be converted
	 * @param value
	 *            The input value to be converted
	 * 
	 * @exception ConversionException
	 *                if conversion cannot be performed successfully
	 */
	public Object convert(Class type, Object value) {

		if (value == null || value.toString().trim().length() == 0) {//hbm : ���ӿ��ַ���ʱ���ж�
			if (useDefault) {
				return (defaultValue);
			} else {
				throw new ConversionException("No value specified");
			}
		}

		if (value instanceof Date) {
			return (value);
		}

		try {
			return (Date.valueOf(value.toString()));
		} catch (Exception e) {
			if (useDefault) {
				return (defaultValue);
			} else {
				throw new ConversionException(e);
			}
		}

	}

}
