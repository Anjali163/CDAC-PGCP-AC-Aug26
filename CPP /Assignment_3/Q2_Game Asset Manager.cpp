//============================================================================
// Name        : Q2_Game.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <memory>
#include <string>
using namespace std;

// Texture Class

class texture{
private:
	string name;
	int width;
	int heigth;

public:
	texture(string n, int w,int h):name(n), width(w), heigth(h){
		cout<< "[Texture Loaded]"<<endl;
	}

	~texture(){
		cout<<" [Texture Released]"<<endl;
	}

	void display() const{
		cout<<"Name : "<<name<<endl;
		cout<<"width : "<<width<<endl;
		cout<<"heigth : "<<heigth<<endl;

	}
};

// Shader Class

class Shader{
private:
	string name;
	string type;

public:
	Shader(string name, string type):name(name),type(type){
		cout<<" [Shader Compiled]"<<endl;
	}

	~Shader(){
		cout<<"[Shader Destroyed]"<<endl;
	}

	int getReferenceCount();
};
	// AudioClip Class

	class AudioClip {

	private:
	    string name;
	    double duration;

	public:

	    AudioClip(string name, double duration)
	        : name(name), duration(duration) {

	        cout << "[AudioClip Loaded]" << endl;
	    }

	    ~AudioClip() {
	        cout << "[AudioClip Released]" << endl;
	    }

	    string getName() const {
	        return name;
	    }
	};



int main() {

	// Part A : unique_ptr

	cout << "===== UNIQUE PTR =====" << endl;

	auto tex1 = make_unique<texture>("player_sprite", 512, 512);
	tex1->display();

	 /*
	       This does NOT work:

	       unique_ptr<Texture> tex2 = tex1;

	       Reason:
	       unique_ptr cannot be copied because it represents
	       exclusive ownership.
	    */
	unique_ptr<texture> tex2 = move(tex1);

	cout << "tex1 is null: " << (tex1 == nullptr ? "YES" : "NO") << endl;

	// Part B : shared_ptr

	cout << "===== UNIQUE PTR =====" << endl;

	auto shader = make_shared<Shader>("main_vert", "vertex");
	cout << "Ref count: " << shader.use_count() << endl;
	{

	auto rendererRef = shader;
	cout << "Ref count: " << shader.use_count() << endl;

	auto editorRef   = shader;
	cout << "Ref count: " << shader.use_count() << endl;
	}

	cout << "Ref count: " << shader.use_count() << endl;

	// Part C : waek_ptr

	cout << "===== WEAK PTR =====" << endl;

	    auto audio = make_shared<AudioClip>(
	        "explosion",
	        3.5
	    );

	    weak_ptr<AudioClip> observer = audio;

	    if (auto clip = observer.lock()) {
	        cout << "Clip alive: "
	             << clip->getName()
	             << endl;
	    }

	    // Unload the audio clip
	    audio.reset();

	    if (observer.expired()) {
	        cout << "Clip already unloaded." << endl;
	    }



	return 0;
}
