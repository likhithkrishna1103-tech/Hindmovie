package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x0 extends Writer {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final StringBuilder f1416v = new StringBuilder(128);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f1415u = "FragmentManager";

    public final void a() {
        StringBuilder sb2 = this.f1416v;
        if (sb2.length() > 0) {
            Log.d(this.f1415u, sb2.toString());
            sb2.delete(0, sb2.length());
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
                this.f1416v.append(c9);
            }
        }
    }
}
