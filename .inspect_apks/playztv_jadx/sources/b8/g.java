package b8;

import android.os.Process;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends Thread {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1936u = 1;

    public /* synthetic */ g(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        switch (this.f1936u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Process.setThreadPriority(19);
                synchronized (this) {
                    while (true) {
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                            return;
                        }
                    }
                }
                break;
            case 1:
                Process.setThreadPriority(9);
                super.run();
                return;
        }
        while (true) {
            try {
                reentrantLock = hf.d.f6104h;
                reentrantLock.lock();
            } catch (InterruptedException unused2) {
            }
            try {
                hf.d dVarB = cf.d.b();
                if (dVarB == hf.d.f6107l) {
                    hf.d.f6107l = null;
                    reentrantLock.unlock();
                    return;
                } else {
                    reentrantLock.unlock();
                    if (dVarB != null) {
                        dVarB.j();
                    }
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public /* synthetic */ g(String str) {
        super(str);
    }

    public /* synthetic */ g(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
