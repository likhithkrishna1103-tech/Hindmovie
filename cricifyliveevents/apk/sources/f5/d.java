package f5;

import a9.l;
import androidx.media3.decoder.DecoderInputBuffer;
import e5.j;
import ge.i;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f3968y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f3969z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d5.b bVar, String str, c cVar) {
        super(bVar, str);
        i.e(bVar, "db");
        i.e(str, "sql");
        this.f3969z = cVar;
    }

    @Override // c5.c
    public final void E(int i, String str) {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i.e(str, "value");
                ((e) this.f3969z).E(i, str);
                return;
            case 1:
                i.e(str, "value");
                a();
                ((j) this.f3969z).n(i, str);
                return;
            default:
                i.e(str, "value");
                a();
                android.support.v4.media.session.b.N(25, "column index out of range");
                throw null;
        }
    }

    @Override // f5.f, c5.c
    public boolean L() {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((e) this.f3969z).L();
            default:
                return super.L();
        }
    }

    @Override // c5.c
    public final boolean V() {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                e eVar = (e) this.f3969z;
                boolean zV = eVar.V();
                boolean zEqualsIgnoreCase = eVar.j(0).equalsIgnoreCase("wal");
                d5.b bVar = this.f3972v;
                if (zEqualsIgnoreCase) {
                    bVar.K();
                } else {
                    bVar.l();
                }
                return zV;
            case 1:
                a();
                ((j) this.f3969z).f3807w.execute();
                return false;
            default:
                int iOrdinal = ((c) this.f3969z).ordinal();
                d5.b bVar2 = this.f3972v;
                if (iOrdinal == 0) {
                    bVar2.N();
                    bVar2.h();
                    return false;
                }
                if (iOrdinal == 1) {
                    bVar2.h();
                    return false;
                }
                if (iOrdinal == 2) {
                    bVar2.i();
                    return false;
                }
                if (iOrdinal == 3) {
                    bVar2.P();
                    return false;
                }
                if (iOrdinal != 4) {
                    throw new l();
                }
                bVar2.v();
                return false;
        }
    }

    @Override // c5.c
    public final void b(int i) {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f3969z).b(i);
                return;
            case 1:
                a();
                ((j) this.f3969z).b(i);
                return;
            default:
                a();
                android.support.v4.media.session.b.N(25, "column index out of range");
                throw null;
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() throws IOException {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f3969z).close();
                break;
            case 1:
                ((j) this.f3969z).close();
                this.f3974x = true;
                break;
            default:
                this.f3974x = true;
                break;
        }
    }

    @Override // c5.c
    public final void e(int i, long j4) {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f3969z).e(i, j4);
                return;
            case 1:
                a();
                ((j) this.f3969z).e(i, j4);
                return;
            default:
                a();
                android.support.v4.media.session.b.N(25, "column index out of range");
                throw null;
        }
    }

    @Override // f5.f, c5.c
    public void f() {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f3969z).f();
                break;
            case 1:
                a();
                ((j) this.f3969z).f();
                break;
            default:
                super.f();
                break;
        }
    }

    @Override // c5.c
    public final int getColumnCount() {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                break;
            case 1:
                a();
                break;
            default:
                a();
                break;
        }
        return 0;
    }

    @Override // c5.c
    public final String getColumnName(int i) {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((e) this.f3969z).getColumnName(i);
            case 1:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
            default:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
        }
    }

    @Override // c5.c
    public final long getLong(int i) {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((e) this.f3969z).getLong(i);
            case 1:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
            default:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
        }
    }

    @Override // c5.c
    public final boolean isNull(int i) {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((e) this.f3969z).isNull(i);
            case 1:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
            default:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
        }
    }

    @Override // c5.c
    public final String j(int i) {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return ((e) this.f3969z).j(i);
            case 1:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
            default:
                a();
                android.support.v4.media.session.b.N(21, "no row");
                throw null;
        }
    }

    @Override // f5.f, c5.c
    public void reset() {
        switch (this.f3968y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((e) this.f3969z).reset();
                break;
            default:
                super.reset();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d5.b bVar, String str, e eVar) {
        super(bVar, str);
        i.e(bVar, "db");
        i.e(str, "sql");
        this.f3969z = eVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d5.b bVar, String str) {
        super(bVar, str);
        i.e(bVar, "db");
        i.e(str, "sql");
        this.f3969z = bVar.p(str);
    }
}
