package v1;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    public InputStream A;
    public long B;
    public boolean C;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final AssetManager f13118y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Uri f13119z;

    public b(Context context) {
        super(false);
        this.f13118y = context.getAssets();
    }

    @Override // v1.h
    public final void close() {
        this.f13119z = null;
        try {
            try {
                InputStream inputStream = this.A;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e10) {
                throw new a(e10, 2000);
            }
        } finally {
            this.A = null;
            if (this.C) {
                this.C = false;
                c();
            }
        }
    }

    @Override // v1.h
    public final long h(m mVar) throws a {
        try {
            Uri uri = mVar.f13157a;
            long j5 = mVar.f;
            this.f13119z = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            d();
            InputStream inputStreamOpen = this.f13118y.open(path, 1);
            this.A = inputStreamOpen;
            if (inputStreamOpen.skip(j5) < j5) {
                throw new a(null, 2008);
            }
            long j8 = mVar.f13162g;
            if (j8 != -1) {
                this.B = j8;
            } else {
                long jAvailable = this.A.available();
                this.B = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.B = -1L;
                }
            }
            this.C = true;
            e(mVar);
            return this.B;
        } catch (a e10) {
            throw e10;
        } catch (IOException e11) {
            throw new a(e11, e11 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // v1.h
    public final Uri o() {
        return this.f13119z;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws a {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.B;
        if (j5 != 0) {
            if (j5 != -1) {
                try {
                    i10 = (int) Math.min(j5, i10);
                } catch (IOException e10) {
                    throw new a(e10, 2000);
                }
            }
            InputStream inputStream = this.A;
            int i11 = s1.b0.f11647a;
            int i12 = inputStream.read(bArr, i, i10);
            if (i12 != -1) {
                long j8 = this.B;
                if (j8 != -1) {
                    this.B = j8 - ((long) i12);
                }
                b(i12);
                return i12;
            }
        }
        return -1;
    }
}
