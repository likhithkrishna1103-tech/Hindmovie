package ag;

import android.os.Process;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends Thread {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f418v = 1;

    public /* synthetic */ b(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ReentrantLock reentrantLock;
        c cVarF;
        switch (this.f418v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                Process.setThreadPriority(9);
                super.run();
                return;
            default:
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
        }
        while (true) {
            try {
                o oVar = c.f419h;
                reentrantLock = c.f420j;
                reentrantLock.lock();
                try {
                    cVarF = jb.b.f();
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } catch (InterruptedException unused2) {
                continue;
            }
            if (cVarF == c.i) {
                c.i = null;
                reentrantLock.unlock();
                return;
            } else {
                reentrantLock.unlock();
                if (cVarF != null) {
                    cVarF.k();
                }
            }
        }
    }

    public /* synthetic */ b(String str) {
        super(str);
    }

    public /* synthetic */ b(ThreadGroup threadGroup, String str) {
        super(threadGroup, str);
    }
}
