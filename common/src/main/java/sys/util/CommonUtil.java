package sys.util;

import java.util.Date;

public final class CommonUtil {
	public static Date last(Date date) {
		int dayMis=1000*60*60*24;//一天的毫秒-1
	    long curMillisecond=date.getTime();//当天的毫秒
	    long resultMis=curMillisecond+(dayMis-1); //当天最后一秒
	    return new Date(resultMis);
	}
	public static String ByteTstr(Object obj) {
		int tmp = ((Byte)obj)&0xff;
		return String.valueOf(tmp);
	}
}
