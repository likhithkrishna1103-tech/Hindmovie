package p6;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import c2.o;
import p7.k;
import p7.l;
import t7.c0;
import t7.d0;
import t7.e0;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Handler.Callback {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f10226u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f10227v;

    public /* synthetic */ f(int i, Object obj) {
        this.f10226u = i;
        this.f10227v = obj;
    }

    private final boolean a(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Received response to request: " + i);
        }
        k kVar = (k) this.f10227v;
        synchronized (kVar) {
            try {
                l lVar = (l) kVar.f10275y.get(i);
                if (lVar == null) {
                    Log.w("MessengerIpcClient", "Received response for unknown request: " + i);
                    return true;
                }
                kVar.f10275y.remove(i);
                kVar.c();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    lVar.b(new o("Not supported by GmsCore", null));
                    return true;
                }
                switch (lVar.f10281e) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        if (data.getBoolean("ack", false)) {
                            lVar.c(null);
                            return true;
                        }
                        lVar.b(new o("Invalid response to one way request", null));
                        return true;
                    default:
                        Bundle bundle = data.getBundle("data");
                        if (bundle == null) {
                            bundle = Bundle.EMPTY;
                        }
                        lVar.c(bundle);
                        return true;
                }
            } finally {
            }
        }
    }

    private final boolean b(Message message) {
        if (message.what != 0) {
            return false;
        }
        e7.c cVar = (e7.c) this.f10227v;
        if (message.obj != null) {
            throw new ClassCastException();
        }
        synchronized (cVar.f4586u) {
            throw null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f10226u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) this.f10227v;
                int i = message.what;
                if (i == 1) {
                    gVar.b((d) message.obj);
                    return true;
                }
                if (i == 2) {
                    gVar.f10231d.p((d) message.obj);
                }
                return false;
            case 1:
                return a(message);
            case 2:
                return b(message);
            default:
                int i10 = message.what;
                if (i10 != 0) {
                    if (i10 != 1) {
                        return false;
                    }
                    synchronized (((e0) this.f10227v).f12289a) {
                        try {
                            c0 c0Var = (c0) message.obj;
                            d0 d0Var = (d0) ((e0) this.f10227v).f12289a.get(c0Var);
                            if (d0Var != null && d0Var.f12260v == 3) {
                                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(c0Var)), new Exception());
                                ComponentName componentName = d0Var.f12264z;
                                if (componentName == null) {
                                    c0Var.getClass();
                                    componentName = null;
                                }
                                if (componentName == null) {
                                    String str = c0Var.f12257b;
                                    v.h(str);
                                    componentName = new ComponentName(str, "unknown");
                                }
                                d0Var.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                        break;
                    }
                } else {
                    synchronized (((e0) this.f10227v).f12289a) {
                        try {
                            c0 c0Var2 = (c0) message.obj;
                            d0 d0Var2 = (d0) ((e0) this.f10227v).f12289a.get(c0Var2);
                            if (d0Var2 != null && d0Var2.f12259u.isEmpty()) {
                                if (d0Var2.f12261w) {
                                    d0Var2.A.f12291c.removeMessages(1, d0Var2.f12263y);
                                    e0 e0Var = d0Var2.A;
                                    e0Var.f12292d.c(e0Var.f12290b, d0Var2);
                                    d0Var2.f12261w = false;
                                    d0Var2.f12260v = 2;
                                }
                                ((e0) this.f10227v).f12289a.remove(c0Var2);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return true;
        }
    }
}
