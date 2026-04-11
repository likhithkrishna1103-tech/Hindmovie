package hb;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements hc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5883b;

    public /* synthetic */ d(int i, Object obj) {
        this.f5882a = i;
        this.f5883b = obj;
    }

    @Override // hc.b
    public final Object get() {
        switch (this.f5882a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) this.f5883b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new m("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e9) {
                    throw new m(l0.e.k("Could not instantiate ", str, "."), e9);
                } catch (InstantiationException e10) {
                    throw new m(l0.e.k("Could not instantiate ", str, "."), e10);
                } catch (NoSuchMethodException e11) {
                    throw new m(q4.a.n("Could not instantiate ", str), e11);
                } catch (InvocationTargetException e12) {
                    throw new m(q4.a.n("Could not instantiate ", str), e12);
                }
            case 1:
                return (ComponentRegistrar) this.f5883b;
            default:
                return new jc.c((ab.g) this.f5883b);
        }
    }
}
