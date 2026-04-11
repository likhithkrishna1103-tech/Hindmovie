package b2;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends c {
    public Uri A;
    public InputStream B;
    public long C;
    public boolean D;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final AssetManager f1673z;

    public b(Context context) {
        super(false);
        this.f1673z = context.getAssets();
    }

    @Override // b2.h
    public final long B(o oVar) throws a {
        try {
            Uri uri = oVar.f1714a;
            long j4 = oVar.f;
            this.A = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            e();
            InputStream inputStreamOpen = this.f1673z.open(path, 1);
            this.B = inputStreamOpen;
            if (inputStreamOpen.skip(j4) < j4) {
                throw new a(null, 2008);
            }
            long j7 = oVar.f1719g;
            if (j7 != -1) {
                this.C = j7;
            } else {
                long jAvailable = this.B.available();
                this.C = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.C = -1L;
                }
            }
            this.D = true;
            f(oVar);
            return this.C;
        } catch (a e9) {
            throw e9;
        } catch (IOException e10) {
            throw new a(e10, e10 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // b2.h
    public final void close() {
        this.A = null;
        try {
            try {
                InputStream inputStream = this.B;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e9) {
                throw new a(e9, 2000);
            }
        } finally {
            this.B = null;
            if (this.D) {
                this.D = false;
                c();
            }
        }
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws a {
        if (i10 == 0) {
            return 0;
        }
        long j4 = this.C;
        if (j4 != 0) {
            if (j4 != -1) {
                try {
                    i10 = (int) Math.min(j4, i10);
                } catch (IOException e9) {
                    throw new a(e9, 2000);
                }
            }
            InputStream inputStream = this.B;
            int i11 = y1.a0.f14551a;
            int i12 = inputStream.read(bArr, i, i10);
            if (i12 != -1) {
                long j7 = this.C;
                if (j7 != -1) {
                    this.C = j7 - ((long) i12);
                }
                b(i12);
                return i12;
            }
        }
        return -1;
    }

    @Override // b2.h
    public final Uri t() {
        return this.A;
    }
}
