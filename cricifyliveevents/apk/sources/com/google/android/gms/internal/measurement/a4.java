package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a4 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2314a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2315b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(f4 f4Var) {
        super(null);
        this.f2315b = f4Var;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.f2314a) {
            case 2:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        Cursor cursor;
        switch (this.f2314a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((AtomicBoolean) ((o.t3) this.f2315b).f9367v).set(true);
                return;
            case 1:
                f4 f4Var = (f4) this.f2315b;
                synchronized (f4Var.f) {
                    f4Var.f2395g = null;
                    f4Var.f2392c.run();
                    break;
                }
                synchronized (f4Var) {
                    try {
                        Iterator it = f4Var.f2396h.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            default:
                o.e3 e3Var = (o.e3) this.f2315b;
                if (!e3Var.f14544w || (cursor = e3Var.f14545x) == null || cursor.isClosed()) {
                    return;
                }
                e3Var.f14543v = e3Var.f14545x.requery();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(o.t3 t3Var) {
        super(null);
        Objects.requireNonNull(t3Var);
        this.f2315b = t3Var;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(o.e3 e3Var) {
        super(new Handler());
        this.f2315b = e3Var;
    }
}
