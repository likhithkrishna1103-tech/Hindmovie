package f5;

import android.database.Cursor;
import ge.i;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends f {
    public double[] A;
    public String[] B;
    public byte[][] C;
    public Cursor D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f3970y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public long[] f3971z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d5.b bVar, String str) {
        super(bVar, str);
        i.e(bVar, "db");
        i.e(str, "sql");
        this.f3970y = new int[0];
        this.f3971z = new long[0];
        this.A = new double[0];
        this.B = new String[0];
        this.C = new byte[0][];
    }

    public static void s(Cursor cursor, int i) {
        if (i < 0 || i >= cursor.getColumnCount()) {
            android.support.v4.media.session.b.N(25, "column index out of range");
            throw null;
        }
    }

    @Override // c5.c
    public final void E(int i, String str) {
        i.e(str, "value");
        a();
        g(3, i);
        this.f3970y[i] = 3;
        this.B[i] = str;
    }

    @Override // c5.c
    public final boolean V() {
        a();
        q();
        Cursor cursor = this.D;
        if (cursor != null) {
            return cursor.moveToNext();
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // c5.c
    public final void b(int i) {
        a();
        g(5, i);
        this.f3970y[i] = 5;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (!this.f3974x) {
            f();
            reset();
        }
        this.f3974x = true;
    }

    @Override // c5.c
    public final void e(int i, long j4) {
        a();
        g(1, i);
        this.f3970y[i] = 1;
        this.f3971z[i] = j4;
    }

    @Override // f5.f, c5.c
    public final void f() {
        a();
        this.f3970y = new int[0];
        this.f3971z = new long[0];
        this.A = new double[0];
        this.B = new String[0];
        this.C = new byte[0][];
    }

    public final void g(int i, int i10) {
        int i11 = i10 + 1;
        int[] iArr = this.f3970y;
        if (iArr.length < i11) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
            i.d(iArrCopyOf, "copyOf(...)");
            this.f3970y = iArrCopyOf;
        }
        if (i == 1) {
            long[] jArr = this.f3971z;
            if (jArr.length < i11) {
                long[] jArrCopyOf = Arrays.copyOf(jArr, i11);
                i.d(jArrCopyOf, "copyOf(...)");
                this.f3971z = jArrCopyOf;
                return;
            }
            return;
        }
        if (i == 2) {
            double[] dArr = this.A;
            if (dArr.length < i11) {
                double[] dArrCopyOf = Arrays.copyOf(dArr, i11);
                i.d(dArrCopyOf, "copyOf(...)");
                this.A = dArrCopyOf;
                return;
            }
            return;
        }
        if (i == 3) {
            String[] strArr = this.B;
            if (strArr.length < i11) {
                Object[] objArrCopyOf = Arrays.copyOf(strArr, i11);
                i.d(objArrCopyOf, "copyOf(...)");
                this.B = (String[]) objArrCopyOf;
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        byte[][] bArr = this.C;
        if (bArr.length < i11) {
            Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i11);
            i.d(objArrCopyOf2, "copyOf(...)");
            this.C = (byte[][]) objArrCopyOf2;
        }
    }

    @Override // c5.c
    public final int getColumnCount() {
        a();
        q();
        Cursor cursor = this.D;
        if (cursor != null) {
            return cursor.getColumnCount();
        }
        return 0;
    }

    @Override // c5.c
    public final String getColumnName(int i) {
        a();
        q();
        Cursor cursor = this.D;
        if (cursor == null) {
            throw new IllegalStateException("Required value was null.");
        }
        s(cursor, i);
        String columnName = cursor.getColumnName(i);
        i.d(columnName, "getColumnName(...)");
        return columnName;
    }

    @Override // c5.c
    public final long getLong(int i) {
        a();
        Cursor cursor = this.D;
        if (cursor != null) {
            s(cursor, i);
            return cursor.getLong(i);
        }
        android.support.v4.media.session.b.N(21, "no row");
        throw null;
    }

    @Override // c5.c
    public final boolean isNull(int i) {
        a();
        Cursor cursor = this.D;
        if (cursor != null) {
            s(cursor, i);
            return cursor.isNull(i);
        }
        android.support.v4.media.session.b.N(21, "no row");
        throw null;
    }

    @Override // c5.c
    public final String j(int i) {
        a();
        Cursor cursor = this.D;
        if (cursor == null) {
            android.support.v4.media.session.b.N(21, "no row");
            throw null;
        }
        s(cursor, i);
        String string = cursor.getString(i);
        i.d(string, "getString(...)");
        return string;
    }

    public final void q() {
        if (this.D == null) {
            this.D = this.f3972v.f0(new pc.c(this));
        }
    }

    @Override // f5.f, c5.c
    public final void reset() {
        a();
        Cursor cursor = this.D;
        if (cursor != null) {
            cursor.close();
        }
        this.D = null;
    }
}
