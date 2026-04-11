package v1;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t extends c {
    public long A;
    public boolean B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RandomAccessFile f13174y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Uri f13175z;

    @Override // v1.h
    public final void close() {
        this.f13175z = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f13174y;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e10) {
                throw new s(e10, 2000);
            }
        } finally {
            this.f13174y = null;
            if (this.B) {
                this.B = false;
                c();
            }
        }
    }

    @Override // v1.h
    public final long h(m mVar) throws s {
        Uri uri = mVar.f13157a;
        long j5 = mVar.f;
        this.f13175z = uri;
        d();
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f13174y = randomAccessFile;
            try {
                randomAccessFile.seek(j5);
                long length = mVar.f13162g;
                if (length == -1) {
                    length = this.f13174y.length() - j5;
                }
                this.A = length;
                if (length < 0) {
                    throw new s(null, null, 2008);
                }
                this.B = true;
                e(mVar);
                return this.A;
            } catch (IOException e10) {
                throw new s(e10, 2000);
            }
        } catch (FileNotFoundException e11) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new s(e11, ((e11.getCause() instanceof ErrnoException) && ((ErrnoException) e11.getCause()).errno == OsConstants.EACCES) ? 2006 : 2005);
            }
            throw new s("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=" + uri.getPath() + ",query=" + uri.getQuery() + ",fragment=" + uri.getFragment(), e11, 1004);
        } catch (SecurityException e12) {
            throw new s(e12, 2006);
        } catch (RuntimeException e13) {
            throw new s(e13, 2000);
        }
    }

    @Override // v1.h
    public final Uri o() {
        return this.f13175z;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws s {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.A;
        if (j5 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f13174y;
            int i11 = s1.b0.f11647a;
            int i12 = randomAccessFile.read(bArr, i, (int) Math.min(j5, i10));
            if (i12 > 0) {
                this.A -= (long) i12;
                b(i12);
            }
            return i12;
        } catch (IOException e10) {
            throw new s(e10, 2000);
        }
    }
}
