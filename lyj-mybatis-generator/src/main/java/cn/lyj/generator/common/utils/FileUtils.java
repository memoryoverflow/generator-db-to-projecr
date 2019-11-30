package cn.lyj.generator.common.utils;

import java.io.File;

/**
 * <p>
 *
 * </p>
 *
 * @author 永健
 * @since 2019-11-21 19:03
 */
public class FileUtils
{
    public static void deleteDir(String dirPath)
    {
        File file = new File(dirPath);
        if (file.isFile())
        {
            file.delete();
        }
        else
        {
            File[] files = file.listFiles();
            if (files == null)
            {
                file.delete();
            }
            else
            {
                for (int i = 0; i < files.length; i++)
                {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }
}
