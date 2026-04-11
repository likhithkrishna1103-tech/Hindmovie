package v1;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z implements h {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final z f13181u = new z();

    @Override // v1.h
    public final long h(m mVar) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // v1.h
    public final Map k() {
        return Collections.EMPTY_MAP;
    }

    @Override // v1.h
    public final Uri o() {
        return null;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // v1.h
    public final void close() {
    }

    @Override // v1.h
    public final void g(e0 e0Var) {
    }
}
