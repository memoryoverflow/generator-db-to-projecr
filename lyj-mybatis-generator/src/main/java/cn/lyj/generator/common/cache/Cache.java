package cn.lyj.generator.common.cache;

import cn.lyj.generator.common.utils.ServletUtils;
import cn.lyj.generator.core.entity.table.LTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-10 15:52
 */
public class Cache
{
    private static final Map<String, List<LTable>> TABLE_CACHE;

    static
    {
        TABLE_CACHE = new HashMap<>();
    }

    public static void removeTableFromCache()
    {
        Cache.TABLE_CACHE.remove(ServletUtils.getIp());
    }

    public static void getTableFromCache()
    {
        Cache.TABLE_CACHE.get(ipKey());
    }

    public static void updateTableToCache(List<LTable> tables)
    {
        Cache.TABLE_CACHE.put(ipKey(), tables);
    }

    private static String ipKey()
    {
        return ServletUtils.getIp();
    }

}
