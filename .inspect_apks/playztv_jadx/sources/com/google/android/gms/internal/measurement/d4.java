package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d4 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2934b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d4(int i, Object obj) {
        super(null);
        this.f2933a = i;
        this.f2934b = obj;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.f2933a) {
            case 2:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z2) {
        Cursor cursor;
        switch (this.f2933a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((AtomicBoolean) ((c2.f) this.f2934b).f2300b).set(true);
                return;
            case 1:
                g4 g4Var = (g4) this.f2934b;
                synchronized (g4Var.f3014y) {
                    g4Var.f3015z = null;
                    g4Var.f3012w.run();
                    break;
                }
                synchronized (g4Var) {
                    try {
                        Iterator it = g4Var.A.iterator();
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
                n.a3 a3Var = (n.a3) this.f2934b;
                if (!a3Var.f13112v || (cursor = a3Var.f13113w) == null || cursor.isClosed()) {
                    return;
                }
                a3Var.f13111u = a3Var.f13113w.requery();
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d4(n.a3 a3Var) {
        super(new Handler());
        this.f2933a = 2;
        this.f2934b = a3Var;
    }
}
