package u4;

import android.database.Cursor;
import be.h;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends g {
    public String[] A;
    public byte[][] B;
    public Cursor C;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int[] f12768x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long[] f12769y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double[] f12770z;

    public static void x(Cursor cursor, int i) {
        if (i < 0 || i >= cursor.getColumnCount()) {
            android.support.v4.media.session.b.O("column index out of range", 25);
            throw null;
        }
    }

    @Override // y4.c
    public final boolean W() {
        a();
        v();
        Cursor cursor = this.C;
        if (cursor != null) {
            return cursor.moveToNext();
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // y4.c
    public final void b(int i) {
        a();
        d(5, i);
        this.f12768x[i] = 5;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (!this.f12774w) {
            a();
            this.f12768x = new int[0];
            this.f12769y = new long[0];
            this.f12770z = new double[0];
            this.A = new String[0];
            this.B = new byte[0][];
            reset();
        }
        this.f12774w = true;
    }

    public final void d(int i, int i10) {
        int i11 = i10 + 1;
        int[] iArr = this.f12768x;
        if (iArr.length < i11) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
            h.d(iArrCopyOf, "copyOf(...)");
            this.f12768x = iArrCopyOf;
        }
        if (i == 1) {
            long[] jArr = this.f12769y;
            if (jArr.length < i11) {
                long[] jArrCopyOf = Arrays.copyOf(jArr, i11);
                h.d(jArrCopyOf, "copyOf(...)");
                this.f12769y = jArrCopyOf;
                return;
            }
            return;
        }
        if (i == 2) {
            double[] dArr = this.f12770z;
            if (dArr.length < i11) {
                double[] dArrCopyOf = Arrays.copyOf(dArr, i11);
                h.d(dArrCopyOf, "copyOf(...)");
                this.f12770z = dArrCopyOf;
                return;
            }
            return;
        }
        if (i == 3) {
            String[] strArr = this.A;
            if (strArr.length < i11) {
                Object[] objArrCopyOf = Arrays.copyOf(strArr, i11);
                h.d(objArrCopyOf, "copyOf(...)");
                this.A = (String[]) objArrCopyOf;
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        byte[][] bArr = this.B;
        if (bArr.length < i11) {
            Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i11);
            h.d(objArrCopyOf2, "copyOf(...)");
            this.B = (byte[][]) objArrCopyOf2;
        }
    }

    @Override // y4.c
    public final int getColumnCount() {
        a();
        v();
        Cursor cursor = this.C;
        if (cursor != null) {
            return cursor.getColumnCount();
        }
        return 0;
    }

    @Override // y4.c
    public final String getColumnName(int i) {
        a();
        v();
        Cursor cursor = this.C;
        if (cursor == null) {
            throw new IllegalStateException("Required value was null.");
        }
        x(cursor, i);
        String columnName = cursor.getColumnName(i);
        h.d(columnName, "getColumnName(...)");
        return columnName;
    }

    @Override // y4.c
    public final long getLong(int i) {
        a();
        Cursor cursor = this.C;
        if (cursor != null) {
            x(cursor, i);
            return cursor.getLong(i);
        }
        android.support.v4.media.session.b.O("no row", 21);
        throw null;
    }

    @Override // y4.c
    public final void i(String str, int i) {
        h.e(str, "value");
        a();
        d(3, i);
        this.f12768x[i] = 3;
        this.A[i] = str;
    }

    @Override // y4.c
    public final boolean isNull(int i) {
        a();
        Cursor cursor = this.C;
        if (cursor != null) {
            x(cursor, i);
            return cursor.isNull(i);
        }
        android.support.v4.media.session.b.O("no row", 21);
        throw null;
    }

    @Override // y4.c
    public final String j(int i) {
        a();
        Cursor cursor = this.C;
        if (cursor == null) {
            android.support.v4.media.session.b.O("no row", 21);
            throw null;
        }
        x(cursor, i);
        String string = cursor.getString(i);
        h.d(string, "getString(...)");
        return string;
    }

    @Override // y4.c
    public final void k(long j5) {
        a();
        d(1, 1);
        this.f12768x[1] = 1;
        this.f12769y[1] = j5;
    }

    @Override // y4.c
    public final void reset() {
        a();
        Cursor cursor = this.C;
        if (cursor != null) {
            cursor.close();
        }
        this.C = null;
    }

    public final void v() {
        if (this.C == null) {
            this.C = this.f12772u.p(new q0.e(12, this));
        }
    }
}
