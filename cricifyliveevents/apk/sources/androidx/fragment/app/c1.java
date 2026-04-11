package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 extends Writer {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final StringBuilder f956w = new StringBuilder(128);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f955v = "FragmentManager";

    public final void a() {
        StringBuilder sb = this.f956w;
        if (sb.length() > 0) {
            Log.d(this.f955v, sb.toString());
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
        a();
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            char c9 = cArr[i + i11];
            if (c9 == '\n') {
                a();
            } else {
                this.f956w.append(c9);
            }
        }
    }
}
