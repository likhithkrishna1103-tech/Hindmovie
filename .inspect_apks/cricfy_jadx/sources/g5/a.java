package g5;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f5025e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f5027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lock f5028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileChannel f5029d;

    public a(String str, File file, boolean z10) {
        Lock lock;
        this.f5026a = z10;
        this.f5027b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap map = f5025e;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5028c = lock;
    }

    public final void a(boolean z10) {
        this.f5028c.lock();
        if (z10) {
            File file = this.f5027b;
            try {
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f5029d = channel;
            } catch (IOException e9) {
                this.f5029d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e9);
            }
        }
    }

    public final void b() {
        try {
            FileChannel fileChannel = this.f5029d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f5028c.unlock();
    }
}
