package h5;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Matrix f5905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f5906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f5907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f5908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f5909e;
    public float f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f5910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f5911h;
    public float i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Matrix f5912j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f5913k;

    public l() {
        this.f5905a = new Matrix();
        this.f5906b = new ArrayList();
        this.f5907c = 0.0f;
        this.f5908d = 0.0f;
        this.f5909e = 0.0f;
        this.f = 1.0f;
        this.f5910g = 1.0f;
        this.f5911h = 0.0f;
        this.i = 0.0f;
        this.f5912j = new Matrix();
        this.f5913k = null;
    }

    @Override // h5.m
    public final boolean a() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f5906b;
            if (i >= arrayList.size()) {
                return false;
            }
            if (((m) arrayList.get(i)).a()) {
                return true;
            }
            i++;
        }
    }

    @Override // h5.m
    public final boolean b(int[] iArr) {
        int i = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.f5906b;
            if (i >= arrayList.size()) {
                return zB;
            }
            zB |= ((m) arrayList.get(i)).b(iArr);
            i++;
        }
    }

    public final void c() {
        Matrix matrix = this.f5912j;
        matrix.reset();
        matrix.postTranslate(-this.f5908d, -this.f5909e);
        matrix.postScale(this.f, this.f5910g);
        matrix.postRotate(this.f5907c, 0.0f, 0.0f);
        matrix.postTranslate(this.f5911h + this.f5908d, this.i + this.f5909e);
    }

    public String getGroupName() {
        return this.f5913k;
    }

    public Matrix getLocalMatrix() {
        return this.f5912j;
    }

    public float getPivotX() {
        return this.f5908d;
    }

    public float getPivotY() {
        return this.f5909e;
    }

    public float getRotation() {
        return this.f5907c;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.f5910g;
    }

    public float getTranslateX() {
        return this.f5911h;
    }

    public float getTranslateY() {
        return this.i;
    }

    public void setPivotX(float f) {
        if (f != this.f5908d) {
            this.f5908d = f;
            c();
        }
    }

    public void setPivotY(float f) {
        if (f != this.f5909e) {
            this.f5909e = f;
            c();
        }
    }

    public void setRotation(float f) {
        if (f != this.f5907c) {
            this.f5907c = f;
            c();
        }
    }

    public void setScaleX(float f) {
        if (f != this.f) {
            this.f = f;
            c();
        }
    }

    public void setScaleY(float f) {
        if (f != this.f5910g) {
            this.f5910g = f;
            c();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.f5911h) {
            this.f5911h = f;
            c();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.i) {
            this.i = f;
            c();
        }
    }

    public l(l lVar, s.e eVar) {
        n jVar;
        this.f5905a = new Matrix();
        this.f5906b = new ArrayList();
        this.f5907c = 0.0f;
        this.f5908d = 0.0f;
        this.f5909e = 0.0f;
        this.f = 1.0f;
        this.f5910g = 1.0f;
        this.f5911h = 0.0f;
        this.i = 0.0f;
        Matrix matrix = new Matrix();
        this.f5912j = matrix;
        this.f5913k = null;
        this.f5907c = lVar.f5907c;
        this.f5908d = lVar.f5908d;
        this.f5909e = lVar.f5909e;
        this.f = lVar.f;
        this.f5910g = lVar.f5910g;
        this.f5911h = lVar.f5911h;
        this.i = lVar.i;
        String str = lVar.f5913k;
        this.f5913k = str;
        if (str != null) {
            eVar.put(str, this);
        }
        matrix.set(lVar.f5912j);
        ArrayList arrayList = lVar.f5906b;
        for (int i = 0; i < arrayList.size(); i++) {
            Object obj = arrayList.get(i);
            if (obj instanceof l) {
                this.f5906b.add(new l((l) obj, eVar));
            } else {
                if (obj instanceof k) {
                    k kVar = (k) obj;
                    k kVar2 = new k(kVar);
                    kVar2.f5897e = 0.0f;
                    kVar2.f5898g = 1.0f;
                    kVar2.f5899h = 1.0f;
                    kVar2.i = 0.0f;
                    kVar2.f5900j = 1.0f;
                    kVar2.f5901k = 0.0f;
                    kVar2.f5902l = Paint.Cap.BUTT;
                    kVar2.f5903m = Paint.Join.MITER;
                    kVar2.f5904n = 4.0f;
                    kVar2.f5896d = kVar.f5896d;
                    kVar2.f5897e = kVar.f5897e;
                    kVar2.f5898g = kVar.f5898g;
                    kVar2.f = kVar.f;
                    kVar2.f5916c = kVar.f5916c;
                    kVar2.f5899h = kVar.f5899h;
                    kVar2.i = kVar.i;
                    kVar2.f5900j = kVar.f5900j;
                    kVar2.f5901k = kVar.f5901k;
                    kVar2.f5902l = kVar.f5902l;
                    kVar2.f5903m = kVar.f5903m;
                    kVar2.f5904n = kVar.f5904n;
                    jVar = kVar2;
                } else if (obj instanceof j) {
                    jVar = new j((j) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f5906b.add(jVar);
                Object obj2 = jVar.f5915b;
                if (obj2 != null) {
                    eVar.put(obj2, jVar);
                }
            }
        }
    }
}
