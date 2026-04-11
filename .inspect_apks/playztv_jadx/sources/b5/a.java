package b5;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashMap f1813e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f1815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lock f1816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileChannel f1817d;

    public a(String str, File file, boolean z2) {
        Lock lock;
        this.f1814a = z2;
        this.f1815b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap map = f1813e;
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
        this.f1816c = lock;
    }

    public final void a(boolean z2) {
        this.f1816c.lock();
        if (z2) {
            File file = this.f1815b;
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
                this.f1817d = channel;
            } catch (IOException e10) {
                this.f1817d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e10);
            }
        }
    }

    public final void b() {
        try {
            FileChannel fileChannel = this.f1817d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f1816c.unlock();
    }
}
