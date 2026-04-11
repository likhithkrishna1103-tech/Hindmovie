package na;

import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements nb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8886b;

    public /* synthetic */ d(int i, Object obj) {
        this.f8885a = i;
        this.f8886b = obj;
    }

    @Override // nb.b
    public final Object get() {
        switch (this.f8885a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = (String) this.f8886b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new m("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e10) {
                    throw new m(e6.j.n("Could not instantiate ", str, "."), e10);
                } catch (InstantiationException e11) {
                    throw new m(e6.j.n("Could not instantiate ", str, "."), e11);
                } catch (NoSuchMethodException e12) {
                    throw new m(l4.a.m("Could not instantiate ", str), e12);
                } catch (InvocationTargetException e13) {
                    throw new m(l4.a.m("Could not instantiate ", str), e13);
                }
            case 1:
                return (ComponentRegistrar) this.f8886b;
            default:
                return new pb.b((ga.g) this.f8886b);
        }
    }
}
