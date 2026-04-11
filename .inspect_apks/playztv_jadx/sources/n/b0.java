package n;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AbsSeekBar;
import android.widget.EditText;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.k4;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f8346d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8347a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f8348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f8349c;

    public /* synthetic */ b0() {
    }

    public KeyListener a(KeyListener keyListener) {
        if (keyListener instanceof NumberKeyListener) {
            return keyListener;
        }
        ((k4) ((u5.c) this.f8349c).f12782v).getClass();
        if (keyListener instanceof g1.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new g1.e(keyListener);
    }

    public void b(AttributeSet attributeSet, int i) {
        switch (this.f8347a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                AbsSeekBar absSeekBar = (AbsSeekBar) this.f8348b;
                kc.b bVarD = kc.b.D(absSeekBar.getContext(), attributeSet, f8346d, i);
                Drawable drawableT = bVarD.t(0);
                if (drawableT != null) {
                    if (drawableT instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableT;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i10 = 0; i10 < numberOfFrames; i10++) {
                            Drawable drawableE = e(animationDrawable.getFrame(i10), true);
                            drawableE.setLevel(10000);
                            animationDrawable2.addFrame(drawableE, animationDrawable.getDuration(i10));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableT = animationDrawable2;
                    }
                    absSeekBar.setIndeterminateDrawable(drawableT);
                }
                Drawable drawableT2 = bVarD.t(1);
                if (drawableT2 != null) {
                    absSeekBar.setProgressDrawable(e(drawableT2, false));
                }
                bVarD.E();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f8348b).getContext().obtainStyledAttributes(attributeSet, g.j.AppCompatTextView, i, 0);
                try {
                    boolean z2 = true;
                    if (typedArrayObtainStyledAttributes.hasValue(g.j.AppCompatTextView_emojiCompatEnabled)) {
                        z2 = typedArrayObtainStyledAttributes.getBoolean(g.j.AppCompatTextView_emojiCompatEnabled, true);
                        break;
                    }
                    typedArrayObtainStyledAttributes.recycle();
                    d(z2);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public g1.b c(InputConnection inputConnection, EditorInfo editorInfo) {
        u5.c cVar = (u5.c) this.f8349c;
        if (inputConnection == null) {
            cVar.getClass();
            inputConnection = null;
        } else {
            k4 k4Var = (k4) cVar.f12782v;
            k4Var.getClass();
            if (!(inputConnection instanceof g1.b)) {
                inputConnection = new g1.b((EditText) k4Var.f3070u, inputConnection, editorInfo);
            }
        }
        return (g1.b) inputConnection;
    }

    public void d(boolean z2) {
        g1.i iVar = (g1.i) ((k4) ((u5.c) this.f8349c).f12782v).f3071v;
        if (iVar.f4843w != z2) {
            if (iVar.f4842v != null) {
                androidx.emoji2.text.m mVarA = androidx.emoji2.text.m.a();
                g1.h hVar = iVar.f4842v;
                mVarA.getClass();
                cf.l.j(hVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = mVarA.f1182a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    mVarA.f1183b.remove(hVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            iVar.f4843w = z2;
            if (z2) {
                g1.i.a(iVar.f4841u, androidx.emoji2.text.m.a().b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable e(Drawable drawable, boolean z2) {
        if (drawable instanceof j0.c) {
            ((j0.d) ((j0.c) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id2 = layerDrawable.getId(i);
                    drawableArr[i] = e(layerDrawable.getDrawable(i), id2 == 16908301 || id2 == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i10 = 0; i10 < numberOfLayers; i10++) {
                    layerDrawable2.setId(i10, layerDrawable.getId(i10));
                    layerDrawable2.setLayerGravity(i10, layerDrawable.getLayerGravity(i10));
                    layerDrawable2.setLayerWidth(i10, layerDrawable.getLayerWidth(i10));
                    layerDrawable2.setLayerHeight(i10, layerDrawable.getLayerHeight(i10));
                    layerDrawable2.setLayerInsetLeft(i10, layerDrawable.getLayerInsetLeft(i10));
                    layerDrawable2.setLayerInsetRight(i10, layerDrawable.getLayerInsetRight(i10));
                    layerDrawable2.setLayerInsetTop(i10, layerDrawable.getLayerInsetTop(i10));
                    layerDrawable2.setLayerInsetBottom(i10, layerDrawable.getLayerInsetBottom(i10));
                    layerDrawable2.setLayerInsetStart(i10, layerDrawable.getLayerInsetStart(i10));
                    layerDrawable2.setLayerInsetEnd(i10, layerDrawable.getLayerInsetEnd(i10));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f8349c) == null) {
                    this.f8349c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z2 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public b0(AbsSeekBar absSeekBar) {
        this.f8348b = absSeekBar;
    }

    public b0(EditText editText) {
        this.f8348b = editText;
        this.f8349c = new u5.c(editText);
    }
}
