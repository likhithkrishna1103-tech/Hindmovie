package b2;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w extends c {
    public Uri A;
    public long B;
    public boolean C;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public RandomAccessFile f1732z;

    @Override // b2.h
    public final long B(o oVar) throws v {
        Uri uri = oVar.f1714a;
        long j4 = oVar.f;
        this.A = uri;
        e();
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f1732z = randomAccessFile;
            try {
                randomAccessFile.seek(j4);
                long length = oVar.f1719g;
                if (length == -1) {
                    length = this.f1732z.length() - j4;
                }
                this.B = length;
                if (length < 0) {
                    throw new v(null, null, 2008);
                }
                this.C = true;
                f(oVar);
                return this.B;
            } catch (IOException e9) {
                throw new v(e9, 2000);
            }
        } catch (FileNotFoundException e10) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new v(e10, ((e10.getCause() instanceof ErrnoException) && ((ErrnoException) e10.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005);
            }
            throw new v("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=" + uri.getPath() + ",query=" + uri.getQuery() + ",fragment=" + uri.getFragment(), e10, 1004);
        } catch (SecurityException e11) {
            throw new v(e11, 2006);
        } catch (RuntimeException e12) {
            throw new v(e12, 2000);
        }
    }

    @Override // b2.h
    public final void close() {
        this.A = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f1732z;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e9) {
                throw new v(e9, 2000);
            }
        } finally {
            this.f1732z = null;
            if (this.C) {
                this.C = false;
                c();
            }
        }
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws v {
        if (i10 == 0) {
            return 0;
        }
        long j4 = this.B;
        if (j4 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f1732z;
            int i11 = y1.a0.f14551a;
            int i12 = randomAccessFile.read(bArr, i, (int) Math.min(j4, i10));
            if (i12 > 0) {
                this.B -= (long) i12;
                b(i12);
            }
            return i12;
        } catch (IOException e9) {
            throw new v(e9, 2000);
        }
    }

    @Override // b2.h
    public final Uri t() {
        return this.A;
    }
}
