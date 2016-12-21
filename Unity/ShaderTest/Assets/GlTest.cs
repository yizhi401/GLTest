using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class GlTest : MonoBehaviour {

	public RawImage image;

	// Use this for initialization
	void Start () {
		AndroidJavaObject mImageLoader = new AndroidJavaObject("com.peter.loadlib.LoadTexture2D");
		if (mImageLoader == null) 
		{
			Debug.LogError("Failed To Load ImageLoader");
		}
		Texture2D texture2D = new Texture2D(128, 128, TextureFormat.ARGB32, false);

		System.Int32 texPtr = mImageLoader.Call <System.Int32> ("loadImageReturnTexturePtr", "/storage/sdcard/cursor.png");
		Debug.Log("texture pointer? " + texPtr);
		Texture2D nativeTexture = Texture2D.CreateExternalTexture (128, 128, TextureFormat.ARGB32 , false, false, (System.IntPtr)texPtr);
		texture2D.UpdateExternalTexture(nativeTexture.GetNativeTexturePtr());
		//gameObject.GetComponent<Renderer>().material.mainTexture = texture2D;
		image.texture = texture2D;
	
	}
	
	// Update is called once per frame
	void Update () {
	
	}
}
