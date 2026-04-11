package b2;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final c0 f1680v = new c0();

    @Override // b2.h
    public final long B(o oVar) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // b2.h
    public final Map j() {
        return Collections.EMPTY_MAP;
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // b2.h
    public final Uri t() {
        return null;
    }

    @Override // b2.h
    public final void close() {
    }

    @Override // b2.h
    public final void d(h0 h0Var) {
    }
}
