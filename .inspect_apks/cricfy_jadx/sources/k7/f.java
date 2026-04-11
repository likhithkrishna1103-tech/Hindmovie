package k7;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import i2.q;
import k8.k;
import k8.l;
import o8.d0;
import o8.e0;
import o8.f0;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Handler.Callback {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f7224w;

    public /* synthetic */ f(int i, Object obj) {
        this.f7223v = i;
        this.f7224w = obj;
    }

    private final boolean a(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Received response to request: " + i);
        }
        k kVar = (k) this.f7224w;
        synchronized (kVar) {
            try {
                l lVar = (l) kVar.f7272z.get(i);
                if (lVar == null) {
                    Log.w("MessengerIpcClient", "Received response for unknown request: " + i);
                    return true;
                }
                kVar.f7272z.remove(i);
                kVar.c();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    lVar.b(new q("Not supported by GmsCore", null));
                    return true;
                }
                switch (lVar.f7277e) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        if (data.getBoolean("ack", false)) {
                            lVar.c(null);
                            return true;
                        }
                        lVar.b(new q("Invalid response to one way request", null));
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
        ma.e eVar = (ma.e) this.f7224w;
        if (message.obj != null) {
            throw new ClassCastException();
        }
        synchronized (eVar.f8417v) {
            throw null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f7223v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                g gVar = (g) this.f7224w;
                int i = message.what;
                if (i == 1) {
                    gVar.b((d) message.obj);
                    return true;
                }
                if (i == 2) {
                    gVar.f7228d.o((d) message.obj);
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
                    f0 f0Var = (f0) this.f7224w;
                    synchronized (f0Var.f9654a) {
                        try {
                            d0 d0Var = (d0) message.obj;
                            e0 e0Var = (e0) f0Var.f9654a.get(d0Var);
                            if (e0Var != null && e0Var.f9643w == 3) {
                                String strValueOf = String.valueOf(d0Var);
                                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                                sb.append("Timeout waiting for ServiceConnection callback ");
                                sb.append(strValueOf);
                                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                                ComponentName componentName = e0Var.A;
                                if (componentName == null) {
                                    d0Var.getClass();
                                    componentName = null;
                                }
                                if (componentName == null) {
                                    String str = d0Var.f9618b;
                                    u.g(str);
                                    componentName = new ComponentName(str, "unknown");
                                }
                                e0Var.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                        break;
                    }
                } else {
                    f0 f0Var2 = (f0) this.f7224w;
                    synchronized (f0Var2.f9654a) {
                        try {
                            d0 d0Var2 = (d0) message.obj;
                            e0 e0Var2 = (e0) f0Var2.f9654a.get(d0Var2);
                            if (e0Var2 != null && e0Var2.f9642v.isEmpty()) {
                                if (e0Var2.f9644x) {
                                    d0 d0Var3 = e0Var2.f9646z;
                                    f0 f0Var3 = e0Var2.B;
                                    f0Var3.f9656c.removeMessages(1, d0Var3);
                                    f0Var3.f9657d.c(f0Var3.f9655b, e0Var2);
                                    e0Var2.f9644x = false;
                                    e0Var2.f9643w = 2;
                                }
                                f0Var2.f9654a.remove(d0Var2);
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
